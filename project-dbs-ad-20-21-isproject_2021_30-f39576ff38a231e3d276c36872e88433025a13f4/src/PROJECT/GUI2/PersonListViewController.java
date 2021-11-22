package PROJECT.GUI2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import PROJECT.DB2.DBContactPerson;
import PROJECT.DB2.DBException;
import PROJECT.LOGIC2.ContactPerson;
import PROJECT.LOGIC2.Locations;
import PROJECT.LOGIC2.Systeem;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fgailly
 */
public class PersonListViewController implements Initializable {
    @FXML
    public TextField txtpersonListView;
    public Button getlocationsbttn;
    private  Systeem model;
    @FXML
    private AnchorPane dataPane;

    @FXML
    private  ListView<ContactPerson> personListView = new ListView<>();
    private static ArrayList<Locations> locations;
    private static ObservableList<ContactPerson> personen = new ObservableList<ContactPerson>() {


        @Override
        public void addListener(ListChangeListener<? super ContactPerson> listChangeListener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super ContactPerson> listChangeListener) {

        }

        @Override
        public boolean addAll(ContactPerson... contactPeople) {
            return false;
        }

        @Override
        public boolean setAll(ContactPerson... contactPeople) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends ContactPerson> collection) {
            return false;
        }

        @Override
        public boolean removeAll(ContactPerson... contactPeople) {
            return false;
        }

        @Override
        public boolean retainAll(ContactPerson... contactPeople) {
            return false;
        }

        @Override
        public void remove(int i, int i1) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<ContactPerson> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(ContactPerson person) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends ContactPerson> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends ContactPerson> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public ContactPerson get(int index) {
            return null;
        }

        @Override
        public ContactPerson set(int index, ContactPerson element) {
            return null;
        }

        @Override
        public void add(int index, ContactPerson element) {

        }

        @Override
        public ContactPerson remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<ContactPerson> listIterator() {
            return null;
        }

        @Override
        public ListIterator<ContactPerson> listIterator(int index) {
            return null;
        }

        @Override
        public List<ContactPerson> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener invalidationListener) {

        }

        @Override
        public void removeListener(InvalidationListener invalidationListener) {

        }
    };

    public void initialize() {
        model = Systeem.getInstance();
        personen = FXCollections.observableArrayList(model.getContactPersons());
        personListView.setItems(personen);

    }

    void addContactPerson(ContactPerson persoon) {
        personen.add(persoon);
    }

    void deleteContactPerson(ContactPerson persoon) {
        personen.remove(persoon);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model = Systeem.getInstance();
        if (!personen.isEmpty()) {
            personen = FXCollections.observableArrayList(model.getContactPersons());
            personListView.setItems(personen);
        }
        //database nodig om de de personen uit de database te halen, anders nullPointerException
    }


    public void openLocations(ActionEvent mouseEvent) {
        try {
            ObservableList<ContactPerson> con = personListView.getSelectionModel().getSelectedItems();
            ContactPerson person = con.get(0);
            ArrayList<Locations> locations = DBContactPerson.getLocations(person.getPhoneNumber());

            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/LocationsOfPerson.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException | DBException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Locations> getLocations() throws DBException {
        /*for(int i = 0; i < Systeem.getContactPersons().size(); i++){
            locations.addAll(DBContactPerson.getLocations();
        }*/
        return locations;
    }

    public void modifyPerson(ActionEvent event) {
        try {
            ObservableList<ContactPerson> con = personListView.getSelectionModel().getSelectedItems();
            ContactPerson person = con.get(0);


            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/LocationsOfPerson.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ObservableList<ContactPerson> getPersonen() {
        return personen;
    }
}

