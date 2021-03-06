package com.example.maya2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;

public class MainApplication extends Application {
    Group root = new Group();
    Scene scene = new Scene(root);
    Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Maya 2.0");
        stage.setScene(scene);
        this.stage = stage;
        GoToLogin();
        stage.show();
    }

    public void GoToLogin() throws Exception {
        LoginMenuController loginMenuController = (LoginMenuController) loadScene("LoginMenu.fxml");
        loginMenuController.setApp(this);
        stage.setWidth(614);
        stage.setHeight(437);
    }

    public void GoToRegister() throws Exception {
        RegisterMenuController registerMenuController = (RegisterMenuController) loadScene("RegisterMenu.fxml");
        registerMenuController.setApp(this);
    }

    public void GoToMaya(String ID, String session) throws Exception {
        if(session.equals("Student")){
            MayaStudentMenuController mayaMenuController = (MayaStudentMenuController) loadScene("MayaStudentMenu.fxml");
            mayaMenuController.setIDSession(ID,session);
            mayaMenuController.setWelcomeText();
            mayaMenuController.setApp(this);
        } else if(session.equals("Staff")){
            MayaStaffMenuController mayaMenuController = (MayaStaffMenuController) loadScene("MayaStaffMenu.fxml");
            mayaMenuController.setIDSession(ID, session);
            mayaMenuController.setWelcomeText();
            mayaMenuController.setApp(this);
        }
        stage.setWidth(614);
        stage.setHeight(437);
    }

    public void GoToSearch(String ID, String session) throws Exception {
        SearchMenuController searchMenuController = (SearchMenuController) loadScene("SearchMenu.fxml");
        searchMenuController.setIDSession(ID, session);
        searchMenuController.setApp(this);
        stage.setWidth(1000);
        stage.setHeight(700);
    }

    public void GoToModify(String ID, String session) throws Exception {
        ModifyMenuController modifyMenuController = (ModifyMenuController) loadScene("ModifyMenu.fxml");
        modifyMenuController.setIDSession(ID, session);
        modifyMenuController.setApp(this);
        stage.setWidth(1000);
        stage.setHeight(700);
    }

    public void GoToCreate(String ID) throws Exception {
        CreateMenuController createMenuController = (CreateMenuController) loadScene("CreateMenu.fxml");
        createMenuController.setID(ID);
        createMenuController.setApp(this);
    }

    public void GoToEdit(ObservableList<String> list, String ID) throws Exception {
        EditMenuController editMenuController = (EditMenuController) loadScene("EditMenu.fxml");
        editMenuController.setIDList(ID, list);
        editMenuController.initializeTextAndBox();
        editMenuController.setApp(this);
    }

    public void GoToModuleRegister(String ID) throws Exception {
        RegisterModuleController registerModuleController = (RegisterModuleController) loadScene("RegisterModule.fxml");
        registerModuleController.setID(ID);
        registerModuleController.InitializeDisplayTable();
        registerModuleController.setApp(this);
    }

    public void GoToTimetable(String ID) throws Exception{
        TimetableMenu timetableMenu = (TimetableMenu) loadScene("TimetableMenu.fxml");
        timetableMenu.setID(ID);
        timetableMenu.initializeTimetable();
        timetableMenu.setApp(this);
        stage.setHeight(535);
        stage.setWidth(610);
    }

    public void GoToViewStudentModule(String ID, String session) throws Exception {
        ViewStudentModuleController viewStudentModuleController = (ViewStudentModuleController) loadScene("ViewStudentModule.fxml");
        viewStudentModuleController.setIDSession(ID, session);
        viewStudentModuleController.initializeModule();
        viewStudentModuleController.setApp(this);
        stage.setWidth(1000);
        stage.setHeight(700);
    }

    public void GoToViewStaffModule(String ID, String session) throws Exception{
        ViewStaffModuleController viewStaffModuleController = (ViewStaffModuleController) loadScene("ViewStaffModule.fxml");
        viewStaffModuleController.setIDSession(ID, session);
        viewStaffModuleController.InitializeModule();
        viewStaffModuleController.setApp(this);
        stage.setWidth(1000);
        stage.setHeight(700);
    }

    public void GoToViewStudentList(String ID, ObservableList<String> selected) throws Exception{
        ViewStudentListController viewStudentListController = (ViewStudentListController) loadScene("ViewStudentList.fxml");
        viewStudentListController.setID(ID);
        viewStudentListController.setList(selected);
        viewStudentListController.InitializeStudentList();
        viewStudentListController.setApp(this);
    }

    public void GoToStatsMenu(String ID) throws Exception{
        StatsMenuController statsMenuController = (StatsMenuController) loadScene("StatsMenu.fxml");
        statsMenuController.setID(ID);
        statsMenuController.setApp(this);
        stage.setWidth(1000);
        stage.setHeight(700);
    }

    //Load the scene from the fxml file and then return the controller class to be accessed
    private Initializable loadScene(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        scene.setRoot(loader.load(MainApplication.class.getResourceAsStream(fxml)));
        return loader.getController();
    }

    public static void main(String[] args) {
        launch();
    }
}