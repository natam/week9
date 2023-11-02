package org.afternoon_classes;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyHierarchy {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void addNode(Employee employee) throws Exception {
        if (root == null) {
            root = new TreeNode(employee);
        } else {
            if (root.employee.getManagerId() == employee.getId()) {
                TreeNode temp = new TreeNode(employee);
                temp.addChild(root);
                root = temp;
            } else {
                TreeNode parent = searchRecursive(root, employee.getManagerId());
                if (parent == null) {
                    throw new Exception("Parent not found for employee: " + employee.toString());
                } else {
                    parent.addChild(new TreeNode(employee));
                    //System.out.println("PARENT: " + parent.employee.getName() + " children: " + String.join(" ", parent.getChildNodes().stream().map(treeNode -> treeNode.getEmployee().getName()).toList()));
                }
            }
        }
    }

    private TreeNode searchRecursive(TreeNode current, int employeeId) {
        if (current.employee.getId() == employeeId) {
            return current;
        } else {
            TreeNode tempNode;
            for (TreeNode childNode : current.getChildNodes()) {
                tempNode = searchRecursive(childNode, employeeId);
                if (tempNode != null) {
                    if (tempNode.getEmployee().getId() == employeeId) {
                        return tempNode;
                    }
                }
            }
        }
        return null;
    }

    public void getHierarchyLevels(List<TreeNode> levelNodes, int level) {
        if (levelNodes.size() > 0) {
            System.out.println();
            System.out.print(getTab(level));
            levelNodes.forEach(treeNode -> System.out.print(treeNode.getEmployee().getJobTitle() + "     "));
            List<TreeNode> newLevel = new ArrayList<>();
            level++;
            for (TreeNode node : levelNodes) {
                if (node.getChildNodes().size() > 0) {
                    newLevel.addAll(node.getChildNodes());
                }
            }
            getHierarchyLevels(newLevel, level);
        }
    }

    public void printReport(){
        getHierarchyLevels(List.of(getRoot()), 0);
    }

    public TreeNode getLowestCommonParent(Employee employee1, Employee employee2) throws Exception {
        TreeNode node1 = searchRecursive(root, employee1.getId());
        TreeNode node2 = searchRecursive(root, employee2.getId());
        if (node1 == null || node2 == null) {
            throw new Exception("One or both employees are not in hierarchy tree");
        } else {
            List<Integer> parentsOfEmployee1 = getParents(node1, new ArrayList<>());
            List<Integer> parentsOfEmployee2 = getParents(node2, new ArrayList<>());
            System.out.println();
            for (int i = 0; i<parentsOfEmployee1.size(); i++) {
                if (parentsOfEmployee2.contains(parentsOfEmployee1.get(i))) {
                    return searchRecursive(root, parentsOfEmployee1.get(i));
                }
            }
            return null;
        }
    }

    public List<Integer> getParents(TreeNode node, List<Integer> parents) {
        if (node != null) {
            TreeNode parent = searchRecursive(root, node.getEmployee().getManagerId());
            if (parent != null) {
                parents.add(parent.getEmployee().getId());
                getParents(parent, parents);
            }
        }
        return parents;
    }

    public String getTab(int level) {
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < level; i++) {
            tab.append("  ");
        }
        return tab.toString();
    }
}
