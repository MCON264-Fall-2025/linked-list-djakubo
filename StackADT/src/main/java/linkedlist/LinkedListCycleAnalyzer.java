package linkedlist;

import org.apache.commons.lang3.NotImplementedException;
import support.CycleInfo;
import support.LLNode;

public class LinkedListCycleAnalyzer<T> {
    public static <T> CycleInfo detectCycleInfo(LLNode<T> head){

        LLNode<T> pointer1 = head;
        LLNode<T> pointer2 = head;

        do {
            if (pointer1.getLink() == null || pointer2.getLink() == null)
            {return new CycleInfo(-1, 0);}
            pointer1 = pointer1.getLink();
            pointer2 = pointer2.getLink().getLink();
        }
        while (pointer1!=pointer2);

        int entryIndex = 0;
        pointer1 = head;
        while(pointer1 != pointer2){
            pointer1 = pointer1.getLink();
            pointer2 = pointer2.getLink();
            entryIndex+=1;
        }

        int cycleLength = 1;
        pointer1 = pointer2.getLink();
        while(pointer1 != pointer2){
            pointer1 = pointer1.getLink();
            cycleLength+=1;
        }

        return new CycleInfo(entryIndex,cycleLength);
    }
}
