package datastructure.node;

import java.util.List;

public interface Node {
    void setValue(String value);
    String getValue();
    void addChildNode(Node node);
    void removeChildNode(Node node);
    List<Node> getChildNode();
    boolean contains(String data);
}
