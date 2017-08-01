package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;

/*
 *  Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

	Note:
	If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
	All airports are represented by three capital letters (IATA code).
	You may assume all tickets form at least one valid itinerary.
	Example 1:
	tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
	Example 2:
	tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
	Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
	
	Credits:
	Special thanks to @dietpepsi for adding this problem and creating all test cases.
	��ĿҪ����������һ��·�ߣ���������ĸ�Ĵ�С�������򣬲��ҳ�����һ��ҪΪ"JFK"
	��������PriorityQueue������У�Ĭ���������������ǰ���Ȼ˳������ģ����ְ���С����������ĸ�����ֵ�˳������
 */
public class Reconstruct_Itinerary_332 {
    Map<String,PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        for(String[] ticket : tickets){
            if(!map.containsKey(ticket[0])){
                PriorityQueue<String> q = new PriorityQueue<>();
                map.put(ticket[0],q);
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        DFS("JFK");
        return result;
    }
    public void DFS(String s){
        PriorityQueue<String> q = map.get(s);
        while(q != null && !q.isEmpty()){
            DFS(q.poll());
        }
        result.addFirst(s);//�ݹ����DFS��ͨ��add����ǰ��ֵ�ĴӴ�С��˳������ģ����Ե���addFirst()����
    }
}
