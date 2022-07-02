package api.rest;

import api.rest.repository.Fruits;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class MainController {
    Fruits fruits = new Fruits();

    @GetMapping
    List<String> getFruitList() {

        return fruits.getAllFruits();
    }

    @GetMapping("{fruitName}")
    String getFruit(@PathVariable("fruitName") String fruit) {

        String isFruitsExists = fruits.getFruit(fruit);
        if (isFruitsExists == null) {
            return "search fail!\n" + ": there is no such fruit = " + fruit;
        }
        return fruit;
    }

    @PostMapping("{fruitName}")
    String addFruit(@PathVariable("fruitName") String fruit) {

        boolean isFruitExists = fruits.addFruit(fruit);
        if (!isFruitExists) {
            return "store fail!\n" + ": List has already same fruit!";
        }
        return fruit + " has added at list";
    }

    @DeleteMapping("{fruitName}")
    String deleteFruit(@PathVariable("fruitName") String fruit) {
        boolean isFruitExist = fruits.deleteFruit(fruit);
        if (!isFruitExist) {
            return "delete fail!\n" + ": there is no such fruit = " + fruit;
        }
        return fruit + " has deleted";
    }

    @PatchMapping("{originFruitName}/{newFruitName}")
    String updateFruit(@PathVariable("originFruitName") String originFruit,
                       @PathVariable("newFruitName") String newFruit) {

        boolean isFruitExist = fruits.updateFruit(originFruit, newFruit);
        if (!isFruitExist) {
            return "change fail!\n" + ": there is no such fruit = " + originFruit;
        }
        return originFruit + " is changed by " + newFruit;
    }
}
