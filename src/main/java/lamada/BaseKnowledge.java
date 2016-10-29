package lamada;


import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BaseKnowledge {

    static enum PurchaseOrderStatus {
        PROCESSING,                 // The purchase order is in creating.
        CREATED,                    // The purchase order is created successfully.
        PENDING,                    // The purchase order has not registered sku, need ASINListing.
        CHECKING_IN,                // The purchase order is arrived FC, Check-in in progress.
        RECEIVED,                   // The purchase order is received and recorded by FC.
        CANCELLED,                  // The purchase order is cancelled and will not be processed any more.
        DONE,                       // The purchase order is done and all items have been received and loaded.
        UNKNOWN,                    // Unrecognized state. The data may be corrupted.
    }


    static class KeyPair {
        String key;
        Integer value;
        public KeyPair(String key, Integer value)
        {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {

        System.out.println(1l^2l);
        System.out.println(1l&2l);
        System.out.println(7&2);
        System.out.println(9&4);


//        // 1
//        List<KeyPair> pairList = new ArrayList<>();
//        pairList.add(new KeyPair("1", 1));
//        pairList.add(new KeyPair("1", 2));
//
//        List<String> keyList = pairList.stream().collect(ArrayList::new, (list, item) ->{
//            list.add(item.getKey());
//        }, List::addAll);
//
//        keyList.forEach(item -> {
//            System.out.println(item);
//        });
//
//        System.out.println(PurchaseOrderStatus.valueOf("PROCESSING").name());
//
//        List<String> data = Arrays.asList("DONE", "UNKNOWN");
//
//        List<PurchaseOrderStatus> result = Optional.of(data)
//                .map(strings -> (List<PurchaseOrderStatus>) strings.stream().map(PurchaseOrderStatus::valueOf).collect(Collectors.toList()))
//                .orElse(Arrays.asList());
//        result.forEach(item -> {System.out.println(item);});

        //List<KeyPair> data = Optional.ofNullable(keyList).map(ArrayList::new)
    }
}
