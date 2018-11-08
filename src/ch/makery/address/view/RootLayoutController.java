package ch.makery.address.view;

import ch.makery.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Контроллер для корневого макета. Корневой макет предоставляет базовый
 * макет приложения, содержащий строку меню и место, где будут размещены
 * остальные элементы JavaFX.
 *
 * @author Marco Jakob
 */
public class RootLayoutController {

    // Ссылка на главное приложение
    private MainApp mainApp;

    /**
     * Вызывается главным приложением, чтобы оставить ссылку на самого себя.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    /**
     * Создаёт пустую адресную книгу.
     */
    @FXML
    private void handleNew() {
        mainApp.getPersonData().clear();
        mainApp.setPersonFilePath(null);
    }

    /**
     * Открывает FileChooser, чтобы пользователь имел возможность
     * выбрать адресную книгу для загрузки.
     */
    @FXML
    private void handleOpen() {

        FileChooser fileChooser = new FileChooser();

        // Задаём фильтр расширений
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Показываем диалог загрузки файла
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadPersonDateFromFile(file);
        }
    }

    /**
     * Сохраняет файл в файл адресатов, который в настоящее время открыт.
     * Если файл не открыт, то отображается диалог "save as".
     */
    @FXML
    private void handleSave() {
        File personFile = mainApp.getPersonFilePath();
        if (personFile != null) {
            mainApp.savePersonDataToFile(personFile);
        }
        else {
            handleSaveAs();
        }
    }

    /**
     * Открывает FileChooser, чтобы пользователь имел возможность
     * выбрать файл, куда будут сохранены данные
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Задаём фильтр расширений
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.savePersonDataToFile(file);
        }
    }

    /**
     * Открывает диалоговое окно about.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("AddressApp");
        alert.setHeaderText("About");
        alert.setContentText("Teach JavaFX with us");
        alert.showAndWait();
    }

    /**
     * Закрывает приложение.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    /**
     * Открывает статистику дней рождений.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
        mainApp.showBirthdayStatistics();
    }



    /**
     * 2 переменные и 2 метода ниже – это мои,
     * сделал сам, додумавшись создать Контроллер для RootLayout
     */

    @FXML
    private MenuItem item1;

    @FXML
    private MenuItem item2;


    public void item1Handler() {
        System.out.println("Menu item clicked!");
    }

    public void item2Handler() {
        System.out.println("Menu item 2 clicked!");
    }

}
