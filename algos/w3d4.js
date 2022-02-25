// DLLNodes have a .next and .prev
class DLLNode {
    constructor(data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// DLLists have both a .head and .tail pointer
class DLList {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    // == Main Methods ==

 // add node before target
    // target is the value of a node in the list
    // consider the edge case where you may have to move the head
    // consider the edge case where you do not find the target
    prepend(target, node) {
        if (!this.head) {
            this.head = node;
            this.tail = node;
        } else {
            let runner = this.head;
            while (runner && runner.data != target)
                runner = runner.next;
            if (!runner) {
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = node;
            } else if (runner == this.head) {
                this.addHead(node);
            } else {
                node.prev = runner.prev;
                node.next = runner;
                runner.prev.next = node;
                runner.prev = node;
            }
        }
    }

    // return true or false if a node exists with data === val
    exists(val) {
        if (!this.head) {
            return false;
        } else if (this.head == this.tail)
            return this.head.data == val;
        else {
            let runFront = this.head;
            let runBack = this.tail;
            while (runFront && runBack && runFront.prev != runBack && runFront != runBack) {
                if (runFront.data == val || runBack.data == val)
                    return true;
                runFront = runFront.next;
                runBack = runBack.prev;
            }
            return false;
        }
    }

    // push to head
    addHead(node) {
        if (!this.head) { // empty list
            this.head = node;
            this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }

    // pop from tail
    removeTail() {
        if (this.head == null) return; // empty list
        if (this.head === this.tail) { // one node
            var temp = this.tail; // set a temp
            this.head = null; // disconnect the head
            this.tail = null; // disconnect the tail
            return temp;
        }
        var temp = this.tail; // set a temp
        this.tail = tail.prev; // move the tail back
        this.tail.next = null; // null out the new tail's next
        temp.prev = null; // null out the temp's prev
        return temp;
    }

    // return is empty
    isEmpty() {
        return this.head === null;
    }

    // == Bonus Methods, just inverted versions of the first set ==

    // push to tail
    addTail(node) { 
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
    }

    // pop from head
    removeHead() { 
        this.head.next.prev = null;
        this.head = this.head.next;
    }

    printList() {
        var runner = this.head;
        while(runner) {
            console.log(runner.data);
            runner = runner.next;
        }
    }
}

// instantiate the DLL
// add a few nodes
// test!

var dll = new DLList();
dll.addHead(new DLLNode(5));
dll.addHead(new DLLNode(4));
dll.addHead(new DLLNode(3));
dll.addHead(new DLLNode(2));
dll.prepend(2, new DLLNode(1));
dll.printList();
console.log(dll.exists(1));
console.log(dll.exists(6));
console.log(dll.exists(4));
console.log(dll.exists(5));
dll.prepend(6, new DLLNode(7));
console.log(dll.exists(7));
dll.printList();