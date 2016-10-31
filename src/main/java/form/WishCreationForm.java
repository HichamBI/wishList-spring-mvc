package form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class WishCreationForm {

    private String id;

    @NotEmpty
    private String label;

    @NotEmpty
    @Pattern(regexp = "\\d*")
    private String quantity;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}