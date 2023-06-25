package Test_1;

public class Implement_Queue {
	static class QueueNode {
		int data;
		QueueNode next;

		QueueNode(int a) {
			data = a;
			next = null;
		}
	}

	static class MyQueue {
		QueueNode front;
		QueueNode rear;

		void push(int a) {
			if (rear == null) {
				rear = new QueueNode(a);
				front = rear;
			} else {
				QueueNode temp = new QueueNode(a);
				rear.next = temp;
				rear = temp;
			}
			System.out.println(a + " pushed into the queue!");
		}

		int pop() {
			QueueNode temp = front;

			if (temp == null) {
				System.out.println("Queue is empty, try adding first then call the pop function!!");
				return -1;
			}

			if (temp.next != null) {
				temp = temp.next;
				int k = front.data;
				front = temp;
				System.out.println(k + " poped from the queue!!");
				return k;
			} else {
				int k = front.data;
				front = null;
				rear = null;
				System.out.println(k + " poped from the queue!!");
				return k;
			}
		}

	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(10);
		q.push(20);
		q.push(30);
		q.push(40);
		q.push(50);
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();
	}

}
