package handlers;

import java.time.ZonedDateTime;
import java.util.*;
import worker.Worker;

/**
 * Класс, отвечающий за работу коллекции
 */

public class CollectionHandler
{
    private LinkedList<Worker> collection = new LinkedList<>();
    private ZonedDateTime initializationDate = ZonedDateTime.now();
    private LinkedList<String> history = new LinkedList<>();
    private boolean[] usedId = new boolean[50000];
    public void sort(){
        Collections.sort(collection, new Comparator<Worker>() {
            @Override
            public int compare(Worker w1, Worker w2) {
                return (int) (w1.getId() - w2.getId());
            }
        });
    }

    /**
     * Метод, добавляющий элемент в коллекцию.
     * @param worker элемент.
     */
    public void addToCollection(Worker worker){
        collection.add(worker);
    }

    /**
     * Метод, удаляющий элемент из коллекции по его ID.
     * @param id ID.
     * @return было ли совершено удаление
     */
    public boolean removeFromCollection(int id){
        for (Worker w : collection){
            if (w.getId() == id) {
                collection.remove(w);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод, удаляющий элемент из коллекции по его индексу.
     * @param index индекс.
     */

    public void removeFromCollectionByIndex(int index){
        collection.remove(index);
    }


    /**
     * Метод, обновляющий элемент коллекции по его ID.
     * @param id ID.
     * @param worker элемент
     * @return было ли совершено обновление
     */
    public boolean updateOfCollection(long id, Worker worker){
        for (Worker w : collection){
            if (w.getId() == id) {
                collection.set(collection.indexOf(w), worker);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод, очищающий коллекцию.
     */
    public void clearCollection(){
        collection.clear();
    }

    /**
     * Метод, возвращающий коллекцию.
     * @return коллекцию.
     */
    public LinkedList<Worker> getCollection(){
        return collection;
    }

    /**
     * Метод, возвращающий массив занятых ID.
     * @return массив занятых ID.
     */
    public boolean[] getUsedId(){
        return usedId;
    }

    /**
     * Метод, освобождающий ID
     * @param id
     */
    public void releaseId(long id){
        usedId[(int)(id)] = false;
    }

    /**
     * Метод, занимающий ID
     * @param id
     */
    public void occupyId(long id){
        usedId[(int)(id)] = true;
    }

    /**
     * Метод, сохраняющий команду в историю
     * @param command
     */
    public void putToTheHistory(String command){
        if (history.size() == 11){
            history.removeFirst();
        }
        history.add(command);
    }

    /**
     * Метод, возвращающий историю команд.
     * @return историю команд.
     */
    public LinkedList<String> getHistory() {
        return history;
    }

    /**
     * Метод, возвращающий дату создания коллекции.
     * @return дату создания коллекции.
     */
    public ZonedDateTime getInitializationDate(){
        return initializationDate;
    }
}
