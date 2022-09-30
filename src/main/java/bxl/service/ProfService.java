package bxl.service;

import bxl.model.dto.ProfDTO;
import bxl.model.entities.Local;
import bxl.model.forms.ProfInsertForm;
import bxl.model.forms.ProfUpdateForm;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


public interface ProfService extends CrudService <ProfDTO , Long, ProfInsertForm, ProfUpdateForm>{


}
