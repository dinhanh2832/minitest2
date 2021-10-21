package service;

import model.People;

import java.util.ArrayList;
import java.util.Comparator;

public class ManagerPeople implements ManagerService<People> {
    private ArrayList<People> peoples = new ArrayList<>();
    private int count = 0;

    public ArrayList<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(ArrayList<People> peoples) {
        this.peoples = peoples;
    }

    public int getCount() {
        return count;
    }

    public ManagerPeople() {
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < peoples.size(); i++) {
            if (peoples.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(People people) {
        people.setId(count);
        count++;
        peoples.add(people);

    }

    @Override
    public void update(People people, int id) {
        int index = findIndexById(id);
        peoples.set(index, people);
    }

    @Override
    public void deleteById(int id) {
        int index = findIndexById(id);
        peoples.remove(index);
    }

    @Override
    public void print() {
        for (People people : peoples) {
            System.out.println(people);
        }
    }

    @Override
    public void sort() {
        peoples.sort(Comparator.comparing(People::getName));
    }

    @Override
    public People getNameStudent(int id) {
        for (People people : peoples) {
            if (people.getId() == id) {
                return people;
            }
        }
        return null;
    }
}
