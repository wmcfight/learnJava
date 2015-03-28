import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Interview {
	private void removeDup(List<Integer> data) {
		if(data.size() <= 1) return;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0,len = data.size(); i<len; ++i) {
			if (set.contains(data.get(i))) {
				data.remove(i);
				--len;
				--i;
			} else {
				set.add(data.get(i));
			}
		}
	}

	public static void main(String[] args) {
		Integer data[] = {1, 5, 4, 2, 7, 2, 6, 5};
		ArrayList<Integer> dataList  = new ArrayList<Integer>();
		Collections.addAll(dataList, data);
		Interview handlerSolution = new Interview();
		handlerSolution.removeDup(dataList);
		for (Integer iter : dataList) {
			System.out.print(iter + " ");
		}
	}

}
