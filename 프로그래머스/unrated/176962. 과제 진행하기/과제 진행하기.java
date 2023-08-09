import java.util.*;

class Solution {
	private class Subject {
		String name;
		String start;
		int playtime;

		public Subject(String name, String start, int playtime) {
			this.name = name;
			this.start = start;
			this.playtime = playtime;
		}
	}

	public String[] solution(String[][] plans) {
		List<String> answer = new ArrayList<>();
		Stack<Subject> stack = new Stack<>();
		PriorityQueue<Subject> pq = new PriorityQueue<Subject>((o1, o2) -> o1.start.compareTo(o2.start));

		for(String[] plan : plans) {
			pq.add(new Subject(plan[0], plan[1], Integer.parseInt(plan[2])));
		}
		
		String time = pq.peek().start;
		
		while (!pq.isEmpty()) {
			Subject now = pq.peek();
			if (time.compareTo(now.start) < 0 && !stack.isEmpty()) {
				now = stack.pop();
			} else {
				now = pq.poll();
				time = now.start;
			}

			int diff = 100;
			if(!pq.isEmpty()) {
				diff = calculateDiff(time, pq.peek());
			}

			if (diff < now.playtime) {
				stack.push(new Subject(now.name, now.start, now.playtime - diff));
				time = pq.peek().start;
			} else {
				answer.add(now.name);
				time = calculateTime(time, now.playtime);
			}
		}
		
		while(!stack.isEmpty()) {
			answer.add(stack.pop().name);
		}

		return answer.toArray(new String[0]);
	}

	private String calculateTime(String now, int playtime) {
		String[] time = now.split(":");
		int h = Integer.parseInt(time[0]);
		int m = Integer.parseInt(time[1]);
		m += playtime;
		while (m >= 60) {
			h++;
			m -= 60;
		}

		return new StringBuilder().append(h < 10 ? "0" + h : h).append(":").append(m < 10 ? "0" + m : m).toString();
	}

	private int calculateDiff(String now, Subject next) {
		String[] time = now.split(":");
		int h = Integer.parseInt(time[0]);
		int m = h * 60 + Integer.parseInt(time[1]);

		String[] time1 = next.start.split(":");
		int h1 = Integer.parseInt(time1[0]);
		int m1 = h1 * 60 + Integer.parseInt(time1[1]);

		return m1 - m;
	}
}