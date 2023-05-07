package programmers;

import java.util.Stack;

/**
 * 제한 사항
 * scoville의 길이는 2 이상 1,000,000 이하입니다.
 * K는 0 이상 1,000,000,000 이하입니다.
 * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 * 입출력 예
 * scoville	K	return
 * [1, 2, 3, 9, 10, 12]	7	2
 *
 */

// 최소 힙을 먼저 구현해야 함
// 정렬순서 때려쳐
// 아니면 그냥 트리가 더 쉬울거 같은데..
// 그러면 가장 마지막에 있는 자식은 어떻게 찾을거며,,


public class Solution_004_42626 {
    static class MyBinaryTree {
        int value;
        MyBinaryTree parent;
        MyBinaryTree leftChild;
        MyBinaryTree rightChild;

        public MyBinaryTree() {
        }

        public MyBinaryTree(int value) {
            this.value = value;
        }

        public MyBinaryTree add(int value, int size) {
            if (size == 1) {
                this.value = value;
                this.swapMyParentIfBiggerThenMe();
                return this;
            }

            if (size % 2 == 0) {
                if (leftChild == null) {
                    this.leftChild = new MyBinaryTree();
                    this.leftChild.parent = this;
                }

                return leftChild.add(value, size / 2);
            }
            else {
                if (rightChild == null) {
                    this.rightChild = new MyBinaryTree();
                    this.rightChild.parent = this;
                }

                return rightChild.add(value, size / 2);
            }
        }

        // 부모랑 자식이랑 value 만 바꾸면 swap이랑 똑같음 ㄷㄷ
        public void swapMyParentIfBiggerThenMe() {
            if (this.parent == null) {
                return ;
            }
            int parentValue = this.parent.getValue();

            if (parentValue > this.value) {
                int temp = this.value;
                this.value = this.parent.getValue();
                this.parent.setValue(temp);

                this.parent.swapMyParentIfBiggerThenMe();
            }
        }


        public int removeTop(int size, MyBinaryTree lastChild) {
            int returnValue = this.value;
            if (size == 1) {
                return returnValue;
            }

            this.value = lastChild.getValue();

            // 마지막 자식의 부모와의 연을 끊어 버리고
            lastChild.severTiesWithParent();

            // swapMyChildByHeapType 을 실행
            swapMyChildIfSmallerThenMe();

            return returnValue;
        }

        public void swapMyChildIfSmallerThenMe() {
            MyBinaryTree leftChild = this.leftChild;
            MyBinaryTree rightChild = this.rightChild;

            if (leftChild == null && rightChild == null) {
                return ;
            }

            assert leftChild!= null;

            if (rightChild == null || leftChild.value < rightChild.value) {
                if (this.value > leftChild.value) {
                    int temp = this.value;
                    this.value = leftChild.getValue();
                    leftChild.setValue(temp);
                    leftChild.swapMyChildIfSmallerThenMe();
                }
            }
            else {
                if (this.value > rightChild.value) {
                    int temp = this.value;
                    this.value = rightChild.getValue();
                    rightChild.setValue(temp);
                    rightChild.swapMyChildIfSmallerThenMe();
                }
            }
        }

        public void severTiesWithParent() {
            MyBinaryTree parent = this.parent;

            if (parent.leftChild == this) {
                parent.leftChild = null;
            }
            else {
                parent.rightChild = null;
            }

        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    static class MinHeap {
        private int size;
        private MyBinaryTree root;

        //아 이래서 배열이나 ArrayList 로 힙을 만드는구나...
        private final Stack<MyBinaryTree> lastMyBinaryTree;

        public MinHeap() {
            this.size = 0;
            lastMyBinaryTree = new Stack<>();
        }

        public void add(int value) {
            this.size++;
            if (size == 1) {
                this.root = new MyBinaryTree();
                this.root.setValue(value);
                lastMyBinaryTree.push(this.root);
            }
            else {
                lastMyBinaryTree.push(this.root.add(value, size));
            }

        }

        public int remove() {
            if (size == 0) {
                return -1;
            }
            else {
                MyBinaryTree pop = lastMyBinaryTree.pop();
                return this.root.removeTop(this.size--, pop);
            }
        }

        public int getSize() {
            return size;
        }
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        MinHeap minHeap = new MinHeap();

        for (int s : scoville) {
            minHeap.add(s);
        }

        int leftHand = -1;
        while (minHeap.getSize() != 0) {
            int minimumScovile = minHeap.remove();
            if (minimumScovile >= K && leftHand == -1) {
                return answer;
            }

            if (leftHand == -1) {
                leftHand = minimumScovile;
            } else {
                int newScovile = leftHand + minimumScovile * 2;
                minHeap.add(newScovile);
                answer++;
                leftHand = -1;
            }

        }
        return -1;
    }
}














