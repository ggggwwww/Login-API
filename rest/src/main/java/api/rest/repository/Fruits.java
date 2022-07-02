package api.rest.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class Fruits {

    public static final List<String> fruits = new ArrayList<>();

    public boolean addFruit(String fruit) {
        if (!fruits.contains(fruit)) {
            fruits.add(fruit);
            return true;
        }
        return false;
    }

    public List<String> getAllFruits() {
        for (String fruit : fruits) {
            log.info("fruits={}", fruit);
        }
        return fruits;
    }


    public String getFruit(String fruit) {
        if (fruits.contains(fruit)) {
            return fruit;
        }
        return null;
    }

    public boolean deleteFruit(String fruit) {
        if (fruits.contains(fruit)) {
            for (int i = 0; i < fruits.size(); i++) {
                if (fruits.get(i).equals(fruit))
                    fruits.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean updateFruit(String originFruit, String newFruit) {
        if (fruits.contains(originFruit)){
            for (int i = 0; i < fruits.size(); i++) {
                if(fruits.get(i).equals(originFruit)){
                    fruits.set(i, newFruit);
                }
            }
            return true;
        }
        return false;
    }
}
