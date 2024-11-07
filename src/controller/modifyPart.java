package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.OutSourced;
import model.Part;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controller that handles the logic for the Modify Part screen based on the modifypart.fxml file.
 */
public class modifyPart implements Initializable {
    /**
     * The inout ToggleGroup groups the toggle buttons for setting In-House vs. Outsourced parts.
     */
    public ToggleGroup inout;
    /**
     * Radio button to set the part as In-House.
     */
    public RadioButton inHouse;
    /**
     * Radio button to set the part as Outsourced.
     */
    public RadioButton outsourced;
    /**
     * The partType label is the label for the text field that displays
     * Machine ID for In-House parts and Company Name for Outsourced parts.
     */
    public Label partType;
    /**
     * Text field for the part ID.
     */
    public TextField partid;
    /**
     * Text field for the part name.
     */
    public TextField partname;
    /**
     * Text field for amount of part in stock.
     */
    public TextField partstock;
    /**
     * Text field for the price of the part.
     */
    public TextField partprice;
    /**
     * Text field for minimum parts allowed in stock.
     */
    public TextField partmin;
    /**
     * Text field for maximum parts allowed in stock.
     */
    public TextField partmax;
    /**
     * Text field for the Machine ID or Company Name, depending on which part type is selected.
     */
    public TextField machinecompany;
    /**
     * Button to trigger saving the part.
     */
    public Button saveBtn;
    /**
     * Cancel button to discard changes to the form.
     */
    public Button cancelBtn;

    /**
     * Creates an alert that is used to display any error or confirmation messages
     * generated by methods within the Add Part controller.
     */
    Alert a = new Alert(Alert.AlertType.NONE);

    /**
     * Holds the Part object that was selected for modification.
     */
    private static Part partToModify;
    /**
     * Stores the index of the Part object from the allParts table.
     */
    private static int partIndex;

    /**
     * Gets part to modify.
     *
     * @param index Index of the part from the allParts table.
     * @param part  The Part object to be modified.
     */
    public static void getPartToModify(int index, Part part) {
        partIndex = index;
        partToModify = part;
    }

    /**
     * Initializes the form and sets the value of the text fields to the appropriate values.
     * Part type (In-House or Outsourced) is also checked to make sure it is handled appropriately.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partid.setText(String.valueOf(partToModify.getId()));
        partname.setText(partToModify.getName());
        partstock.setText(String.valueOf(partToModify.getStock()));
        partmin.setText(String.valueOf(partToModify.getMin()));
        partmax.setText(String.valueOf(partToModify.getMax()));
        partprice.setText(String.valueOf(partToModify.getPrice()));
        if (partToModify instanceof InHouse) {
            inHouse.setSelected(true);
            partType.setText("Machine ID");
            machinecompany.setText(String.valueOf(((InHouse) partToModify).getMachineID()));
        } else if (partToModify instanceof OutSourced) {
            outsourced.setSelected(true);
            partType.setText("Company Name");
            machinecompany.setText(((OutSourced) partToModify).getCompanyName());
        }
    }

    /**
     * Validates user input in text fields to make sure null or invalid types
     * are not entered.
     *
     * @return Boolean b; true if input is valid, false if any of the values does not pass validation.
     */
    private boolean validateInput() {
        Boolean b = false;
        if (partname.getText() == null) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Part name cannot be blank.");
            a.show();
        }
        else if (inHouse.isSelected()) {
            try {
                Double.parseDouble(partprice.getText());
                Integer.parseInt(partstock.getText());
                Integer.parseInt(partmax.getText());
                Integer.parseInt(partmin.getText());
                Integer.parseInt(machinecompany.getText());
                b = true;
            } catch (NumberFormatException ignored) {
            }
        } else if (outsourced.isSelected()) {
            try {
                Double.parseDouble(partprice.getText());
                Integer.parseInt(partstock.getText());
                Integer.parseInt(partmax.getText());
                Integer.parseInt(partmin.getText());
                b = true;
            } catch (NumberFormatException ignored) {
            }

        }
        return b;
    }

    /**
     * Event handler to handle saving the updated part. Error messages will be generated if invalid input
     * is found. Closes the window on a successful save.
     *
     * @param actionEvent Used to determine the source of the triggering event so that the
     *                    related window can be closed.
     */
    public void onSave(ActionEvent actionEvent) {
        if (validateInput()) {
            if (inHouse.isSelected()) {
                InHouse newInHousePart = new InHouse(partToModify.getId(), partname.getText(), Double.parseDouble(partprice.getText()), Integer.parseInt(partstock.getText()), Integer.parseInt(partmin.getText()), Integer.parseInt(partmax.getText()), Integer.parseInt(machinecompany.getText()));
                Inventory.updatePart(partIndex, newInHousePart);
            } else if (outsourced.isSelected()) {
                OutSourced newOutsourcedPart = new OutSourced(partToModify.getId(), partname.getText(), Double.parseDouble(partprice.getText()), Integer.parseInt(partstock.getText()), Integer.parseInt(partmin.getText()), Integer.parseInt(partmax.getText()), machinecompany.getText());
                Inventory.updatePart(partIndex, newOutsourcedPart);
            }
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        } else {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Check your input and try again. Numeric fields will accept digits only; please do not use symbols or spaces.");
            a.show();
        }
    }

    /**
     * Event handler to handle a user choosing the cancel button. Provides a confirmation
     * dialog to allow the user the choice to cancel their action; if user chooses to cancel,
     * no information is removed, and if user chooses OK the information in the window is discarded
     * and the window is closed.
     *
     * @param actionEvent Used to determine the source of the triggering event so that the
     *                    related window can be closed.
     */
    public void onCancel(ActionEvent actionEvent) {
        a.setAlertType(Alert.AlertType.CONFIRMATION);
        a.setHeaderText(null);
        a.setContentText("Cancel without saving changes?");
        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    /**
     * Handler to change partType label when user selects the In-House radio button.
     *
     * @param actionEvent Not used.
     */
    public void onInHouse(ActionEvent actionEvent) {
        partType.setText("Machine ID");
    }

    /**
     * Handler to change partType label when user selects the Outsourced radio button.
     *
     * @param actionEvent Not used.
     */
    public void onOutsourced(ActionEvent actionEvent) {
        partType.setText("Company Name");
    }
}
