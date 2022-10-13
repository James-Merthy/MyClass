package bxl.service;

import bxl.model.dto.LeconDTO;
import bxl.model.forms.LeconForm;
import org.springframework.security.core.Authentication;

public interface LeconService extends CrudService <LeconDTO , Long , LeconForm, LeconForm> {


    LeconDTO create(LeconForm toInsert, Authentication auth);
}
