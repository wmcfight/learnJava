package lamada;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mingchuw on 16/6/17.
 */
public class TestStreamFilter {

    public static void main(String[] args) {
        List<Item> data = new ArrayList<>();
        Item item = new Item();
        item.setMsku("14111");
        item.setQuantity(11);
        data.add(item);


        test(data);
    }

    static class Item {
        private java.lang.String msku;
        private java.lang.String productNo;
        private java.lang.String asin;
        private java.lang.String barcode;
        private java.util.Map<java.lang.String,java.lang.String> otherAsinData;
        private int quantity;


        public String getMsku() {
            return msku;
        }

        public void setMsku(String msku) {
            this.msku = msku;
        }

        public String getProductNo() {
            return productNo;
        }

        public void setProductNo(String productNo) {
            this.productNo = productNo;
        }

        public String getAsin() {
            return asin;
        }

        public void setAsin(String asin) {
            this.asin = asin;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public Map<String, String> getOtherAsinData() {
            return otherAsinData;
        }

        public void setOtherAsinData(Map<String, String> otherAsinData) {
            this.otherAsinData = otherAsinData;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public static void test( List<Item> data) {
        Set<String> mskuInErrMsgSet = new HashSet<>();
        List<Item> result = data.stream()
                .filter(e -> mskuInErrMsgSet.contains(e.getMsku())).collect(Collectors.toList());
        System.out.println(result);
    }
}
