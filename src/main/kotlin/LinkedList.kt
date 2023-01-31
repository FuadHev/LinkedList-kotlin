
class MyLinkedList <T> {
    data class Node<T>(var data: T, var next: Node<T>?)

    var size = 0
    var head: Node<T>? = null


    fun printAll() {
        var currentNode = head
        if (currentNode == null) {
            println("Linkedlist is empty")

        } else {
            print("${currentNode!!.data} ")
            while (currentNode!!.next != null) {
                currentNode = currentNode.next
                print("${currentNode!!.data} ")
            }
        }


    }

    fun add(data: T) {
        if (size == 0) {
            head = Node(data, null)
            size++
        } else {
            var currentNode = head
            while (currentNode!!.next != null) {
                currentNode = currentNode.next
            }
            currentNode.next =Node(data, null)
            size++
        }
    }
    fun addelement(index: Int,data: T){
        var currentNode=head
        repeat(index){
            currentNode=currentNode!!.next

        }
        if(currentNode==null){
            println(-1)
        }else {
            currentNode!!.next = Node(data, currentNode!!.next)
            size++
        }


    }

    fun get(index: Int):T {
        var currentNode = head
        repeat(index) {
            currentNode = currentNode!!.next
        }

        return currentNode!!.data!!
    }

    // tapsiriq 4
    fun  replace(index:Int,data:T){
        var currentNode=head
        repeat(index) {
            currentNode = currentNode!!.next
        }
        if(currentNode==null){
            println(-1)
        }
        currentNode!!.data=data

    }

    fun replaceAll(old:T,data: T){
        var currentNode=head
        var t=0
        if (currentNode!!.data==old) {
            currentNode.data=data
        }
        while (currentNode!!.next !=null){
            currentNode = currentNode.next
            if (currentNode!!.data==old){
                currentNode.data=data
                t++
            }

        }
        if (t==0){
            println(-1)
        }

    }

    fun addAll(items:List<T>){
        var currentNode=head
        while (currentNode!!.next !=null){
            currentNode=currentNode.next
        }
        for (i in items){
            add(i)
            size++

        }

    }

    fun addAll(index: Int,items:List<T>){
        var currentNode=head
        repeat(index){
            currentNode=currentNode!!.next
        }

        for (i in items){
            println(i)
            currentNode!!.next= Node(i, currentNode!!.next)
            size++

        }

    }

    fun removeAt(index: Int) {
        if (index==0){
            head=head!!.next
            --size
        }else{
            var currentNode = head
            for(i in 1 until index){
                currentNode = currentNode!!.next
            }
            if(currentNode==null){
                println(-1)
            }else{
                currentNode!!.next = currentNode.next!!.next
                --size
            }

        }


    }
    fun remove(data:T){
        var currentNode=head
        var check=0
        if (currentNode!!.data==data){
            head=head!!.next
            --size
            currentNode=head
        }
        for (i in 1 until size){
            if (currentNode!!.next?.data == data){
                currentNode.next=currentNode.next?.next
                check++
                --size
            }else{
                currentNode=currentNode.next
            }

        }
        if (check==0){
            println( "data in not available")
        }







    }
    fun getFirstIndex(data:T):Int?{
        var check:Int?=null
        var currentNode=head

        for(i in 0 until size){
            if (currentNode!!.data==data){
                check=i
                break
            }
            currentNode=currentNode.next
        }


        return check
    }



    fun getLastIndex(data:T):Int?{
        var check:Int?=null
        var currentNode=head

        for(i in 0 until size){
            if (currentNode!!.data==data){
                check=i
            }
            currentNode=currentNode.next
        }


        return check
    }




    fun getIndices0f(data:T):List<Int>{
        val list =ArrayList<Int>()
        var currentNode=head
        var check=0
        for(i in 0 until size){
            if(currentNode!!.data==data){
                list.add(i)
                ++check
            }
            currentNode= currentNode.next

        }
        if (check==0){
            return emptyList()
        }
        return list
    }


    fun clear(){
        head=null
        size=0
    }



}
data class Person(var userId:Int,var userName:String,var age:Int,var salary:Int)

fun main(){
    val myList =MyLinkedList<Person>()

    myList.add(Person(1,"F",33,4030))
    myList.add(Person(2,"wet",38,4340))
    myList.add(Person(3,"dhf",55,456))
    myList.add(Person(4,"fhdf",13,4040))



}