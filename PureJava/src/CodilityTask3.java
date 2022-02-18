import java.util.*;
import java.util.stream.*;

public class CodilityTask3 {
	
	public static void main(String[] args) {
		
		boolean contentStreamIsnull = false;
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah", null};
		
		//System.out.println(Stream.of(names).filter(Objects::isNull).isPresent());
		
		
		//Stream<Stream<String>> s;
		//s.findFirst().get()
		//Stream.of(names).findFirst().ifPresent();
		
		//System.out.println(IfDataExists(Stream.of(names)));
	}

	
    private static boolean IfDataExists(Stream<Stream<String>> sr){
        if (sr == null)
            return false;
        if (sr.findFirst().isPresent())
            return false;
         
        return true;
    }
    
}










/*

package com.codility;

import java.util.*;
import java.util.stream.*;

class Reconciler {

    Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending, 
                                         Stream<Stream<ProcessedTransaction>> processed) {
        
        // Here bug was code doesn't check for empty Stream
        //if(pending == null && processed == null) {
        //    return Stream.empty();
        //}
        
        if (!IfPendingDataExists(pending))
            return Stream.empty();
        
        if (!IfProcessedDataExists(processed))
            return Stream.empty();        
        
        Stream<Long> filteredProcessedId = processed
                .flatMap(p -> p)
                .filter(Objects::nonNull)
                .filter(p -> p.getStatus() != null && 
                "DONE".equals(p.getStatus().orElse(null)))
                .filter(p -> p.getId() != null && p.getId().length() > 0)
                .map(p -> Long.parseLong(p.getId()));

        return pending.filter(p -> filteredProcessedId.anyMatch(pr -> pr.equals(p.getId())));
    }
    
    private boolean IfPendingDataExists(Stream<PendingTransaction> sr){
        if (sr == null)
            return false;
        if (!sr.findFirst().isPresent())
            return false;
        
        return true;
    }
    
    private boolean IfProcessedDataExists(Stream<Stream<ProcessedTransaction>> sr){
        if (sr == null)
            return false;
        if (!sr.findFirst().isPresent())
            return false;
        
        return true;
    }    

}






















*/