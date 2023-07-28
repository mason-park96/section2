/*
코플릿 자료구조 6번 문제
*/

package datastructure.tree;
import java.util.*;

public class ImplementTree {
    // 현재 노드
    private String value;
    // 자식 노드. 다자 트리를 상정하고 공간을 미리 할당해놓는 느낌. 자리를 마련해놓는 느낌
    // 마련해놓은 자리 한 칸당 하나의 자식 노드가 삽입됨
    // 이건 2진 트리가 아니라 다자트리 아냐?
    private ArrayList<ImplementTree> children;

    public ImplementTree() {	//전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }
    public ImplementTree(String data) {	//전달인자가 존재할 경우의 생성자
        this.value = data;  // 현재 노드에 삽입할 데이터
        this.children = null;
    }

    public void setValue(String data) { // 현재 노드에 데이터 삽입하는 메서드?
        this.value = data;
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return this.value;
    }

    // 자식 노드를 삽입하기 위한 조건이 어떻게 되지?
    // 자식 노드 자리가 비어있어야하나?
    public void addChildNode(ImplementTree node) {
        if(children == null) children = new ArrayList<>();
        children.add(node);
    }
    public void removeChildNode(ImplementTree node) {
        // 입력받은 노드의 현재 노드 데이터를 String data 변수에 넣어준다.
        // 이것이 삭제할 데이터이다.
        String data = node.getValue();

        // 현재 노드가 자식 노드를 가지고 있다면
        if(children != null) {
            // 자식 노드 전체를 순회하여 (배열 리스트라 적절한 접근 방식임)
            for(int i = 0; i < children.size(); i++) {
                // children List 의 i 번째 요소에 대한 현재 노드값이 data 와 같은 값이라면 --> i 번째 요소 삭제
                if(children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                // 만약 i 번째 노드에 자식이 있다면, i번째 요소의 자식 노드에도 data 와 같은 값을 가지는 노드를 삭제
                // 재귀함수를 활용하여 모든 하위 노드를 탐색한다.
                if(children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    public ArrayList<ImplementTree> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        boolean check;

        // 자식 노드가 있다면! 자식 노드도 함 싹 다 탐색해서 확인해봐
        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                //
                check = children.get(i).contains(data, false);
                if(check) return true;
            }
        }
        return false;
    }

    // 올 ㅋㅋ 메서드 오버로딩~~. 이렇게 쓰는구나. 같은 동작을 하니까
    public boolean contains(String data, boolean check) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                // 이것도 재귀 활용하여 모든 자식 노드 다 탐색
                check = children.get(i).contains(data, check);
            }
        }
        return check;
    }

    // toString 메서드 오버라이드
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Value: ").append(this.value).append(", Childern: [");
        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                // ArrayList<ImplementTree> children 의 i 번째 요소의 value 를 sb 에 삽입
                sb.append(children.get(i).getValue());
                if (i < children.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        // 모든 children 의 요소를 다 sb 에 삽입한 후에 닫아주기
        sb.append("]");
        // StringBuilder 는 toString() 메서드를 돌려줘야 sout 으로 출력 가능한가? 가 아니라 그 동작을 출력시 생략시키기 위해서구나 섬세함 굿
        return sb.toString();
    }
}
