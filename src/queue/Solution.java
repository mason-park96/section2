package queue;

import java.util.*;

public class Solution {
    private String value;   // 현재 노드 (부모 노드)
    private ArrayList<Solution> children;   // 자식 노드. 다자트리네

    public Solution() {    //전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }

    public Solution(String data) {    //전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data;
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return this.value;
    }

    public void addChildNode(Solution node) {
        if (children.isEmpty()) children = new ArrayList<>();
        children.add(node);
    }

    public void removeChildNode(Solution node) {
        String data = node.getValue();

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                if (children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    public ArrayList<Solution> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if (value.equals(data)) return true;

        boolean check;

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                check = children.get(i).contains(data, false);
                if (check) return true;
            }
        }
        return false;
    }

    public boolean contains(String data, boolean check) {      //재귀를 사용하여 값을 검색합니다.
        if (value.equals(data)) return true;

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                check = children.get(i).contains(data, check);
            }
        }
        return check;
    }
}
