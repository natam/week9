package org.afternoon_classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    Employee employee;
    List<TreeNode> childNodes;

    public TreeNode(Employee employee){
        this.employee = employee;
        childNodes = new LinkedList<>();
    }

    public void addChild(TreeNode node){
        childNodes.add(node);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<TreeNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<TreeNode> childNodes) {
        this.childNodes = childNodes;
    }
}
