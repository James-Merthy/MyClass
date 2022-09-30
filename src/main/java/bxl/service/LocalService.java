package bxl.service;

import bxl.model.dto.LocalDTO;
import bxl.model.forms.LocalInsertForm;
import bxl.model.forms.LocalUpdateForm;

public interface LocalService extends CrudService <LocalDTO, Long , LocalInsertForm, LocalUpdateForm>  {
}
