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

		void enqueue(int a) {
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

		int dequeue() {
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
		boolean isEmpty() {
			if(front == null) {
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		if(q.isEmpty() == true) {
			System.out.println("Queue is Empty!!");
		}
	}

}
