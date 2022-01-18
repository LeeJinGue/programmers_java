package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution_get_declaration_result {

	// �� ������ ���� �� �Ű��� �� ������ �ߺ��Ű��� ���� 1������ ģ��.
	
	// �־��� ���� ����
	// id_list: ��� �̿����� ID�� ��� String[] -> ID�� ���ĺ� �ҹ���
	// �ڱ��ڽ� �Ű� X -> ����ó���ؾ��ҵ�
	// report: �� �̿��ڰ� �Ű��� �̿����� ID ������ ��� ���ڿ� �迭
	// -> �� ���Ҵ� "�̿���id �Ű���id"
	// k: ���� �Ǵ� �Ű� Ƚ��.
	// answer: �� �������� ó�� ��� ������ ���� Ƚ���� ��� int[]
	// result: �� ������ ���� ��� ���� ��
	
	// �� �迭�� ��������
	// 1 <= id_list.length <= 1000, 
	// 1 <= id_list[n].length <= 10,
	// 1 <= report.length <= 200,000
	// 3 <= report[n].length <= 21
	// 1 <=k <= 200
	
	// ����
	// 1. report�� ��� �� ���Ҹ� �˻��ؼ� �Ű���ID�� �Ű���� �� ID�� �и��Ѵ�.
	// -> �Ű���ID: reporter, �Ű������ID: reportee
	// 	1) �ߺ��� �Ű����� �˻�
	// 	2) �ƴ϶�� Map1���� reportee�� ���� �Ű���� Ƚ�� +1
	// 	3) Map2���� reportee�� ���� reporter�� ���ҷ� �߰�
	// 2. idAndumReport�� ���鼭 �� ���̵��� �Ű���� Ƚ���� k�̻��̸� ������Ų��.
	// 	1) �������ߴٴ� ���� ����Ѵ�.
	// 	2) �������� ����� ���������� �޴´�.
	// 	3) �������� ����� �Ű��� ����� �ش� ������ ���� ����� ���Ϸ� �޴´�.
	
	// idAndnumReport<ID, �Ű����Ƚ��> - Key: �Ű���� ���
	// idAndreporterMap<ID, �ڱ⸦ �Ű��� ID ArrayList> - Key: �Ű���� ���
	// idAndMailNumMap<ID, ����Ƚ��>
 
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		HashMap<String, Integer> idAndnumReport = new HashMap<>();
		HashMap<String, ArrayList<String>> idAndreporterMap = new HashMap<>();
		HashMap<String, Integer> idAndMailNumMap = new HashMap<>();
		// �����ID, �Ű����Ƚ�� Map �ʱ�ȭ
		// + �����ID, ������ �Ű��� ID����Ʈ Map �ʱ�ȭ
		for(String id : id_list) {
			idAndnumReport.put(id,0);
			idAndreporterMap.put(id, new ArrayList<String>());
			idAndMailNumMap.put(id, 0);
		}
		
		mapTest1(idAndnumReport);
		mapTest2(idAndreporterMap);
		
		// report�� ��� �� ���Ҹ� �˻��ؼ� reporter�� reportee�� �и��Ѵ�.
		for(String s : report) {
			String[] split = s.split(" ");
			String reporter = split[0];// �Ű��� ���
			String reportee = split[1]; // �Ű���� ���
			// �� ���������� �׽�Ʈ
			System.out.println("�Ű��� ���: " + split[0] + ", �Ű���� ���: "+split[1]);

			// �ߺ��� �Ű��� �н��Ѵ�.
			if(idAndreporterMap.get(reportee).contains(reporter)) {
			}else {
				idAndnumReport.replace(reportee, idAndnumReport.get(reportee)+1);
				idAndreporterMap.get(reportee).add(reporter);
			}
		}
		mapTest1(idAndnumReport);
		mapTest2(idAndreporterMap);
		mapTest1(idAndMailNumMap);
		
		for(String s : idAndnumReport.keySet()) {
			int numReport = idAndnumReport.get(s);
			if(numReport >= k) {
				System.out.println(s +"�� �����Ǿ����ϴ�.");
				// ������ ���̵� �Ű��� ������� ����Ƚ�� +1
				for( String reporter : idAndreporterMap.get(s)) {
					idAndMailNumMap.replace(reporter, idAndMailNumMap.get(reporter)+1);
					System.out.println("reporter: " + reporter);
				}
			}
		}
		mapTest1(idAndMailNumMap);
		// �迭 ������� ���� ��ҵ��� answer�� �ִ´�.
		int i = 0;
		for(String s : id_list) {
			answer[i] = idAndMailNumMap.get(s);
			i++;
		}
        return answer;
    }
	public void mapTest1(HashMap<String, Integer> map1) {
		for(String s : map1.keySet()) {
			System.out.println("Key: " + s + ", Value: " + map1.get(s));
		}
	}
	public void mapTest2(HashMap<String, ArrayList<String>> map1) {
		for(String s : map1.keySet()) {
			System.out.println("Key: " + s + ", Value: " + map1.get(s));
		}
	}
	
}
