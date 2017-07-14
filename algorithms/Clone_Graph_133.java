package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Clone_Graph_133 {
	private Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
	public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node){//�ǵݹ鷽ʽ
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		map.put(node, newNode);
		queue.add(node);
		while(!queue.isEmpty()){
			UndirectedGraphNode top = queue.poll();
			ArrayList<UndirectedGraphNode> neighbors = top.neighbors;
			
			for(UndirectedGraphNode each : neighbors){//ѭ�����ƽڵ�
				if(!map.containsKey(each)){
					UndirectedGraphNode newNode1 = new UndirectedGraphNode(each.label);
					map.put(each, newNode1);
					queue.add(each);//���Ѹ��ƵĽڵ��������У���Ϊ�´��´�ѭ���Ķ�ͷ
				}
				map.get(top).neighbors.add(map.get(each));
			}
		}
		return newNode;
	}
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {//�ݹ鷽ʽ
        if(node == null){
        	return null;
        }
        if(map.containsKey(node)){
        	return map.get(node);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node,newNode);
        for(UndirectedGraphNode neighbor : node.neighbors){
        	newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
	}
}
