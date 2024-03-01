package bbrz.textadventure.rooms;

import bbrz.textadventure.customException.RoomNotFoundException;
import bbrz.textadventure.item.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Location {

    @Getter
    private final String name;
    @Getter
    private final String description;
    private final List<LocationPointer> pointers = new ArrayList<>();
    @Getter
    private final List<Item> items = new ArrayList<>();

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Location getRoom(String direction) throws RoomNotFoundException {
        for (LocationPointer pointer : pointers) {
            if (pointer.isDirection(direction)) {
                return pointer.getTarget();
            }
        }
        throw new RoomNotFoundException("There is no room in this direction.");
    }

    public void addPointers(LocationPointer ... pointers) {
        this.pointers.addAll(List.of(pointers));
    }

    public void addItems(Item ... items) {
        this.items.addAll(List.of(items));
    }

    public void removeItems(Item ... items) {
        for (Item item : items) {
            this.items.remove(item);
        }
    }

    public List<String> getPointerDirections() {
        List<String> result = new ArrayList<>();

        for (LocationPointer pointer : pointers) {
            result.add(pointer.getDirection() + " => " + pointer.getTarget().name);
        }

        return result;
    }
}