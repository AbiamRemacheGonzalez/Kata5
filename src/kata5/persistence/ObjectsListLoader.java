/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5.persistence;

import java.util.List;
import kata5.model.Mail;

/**
 *
 * @author abiam
 */
public interface ObjectsListLoader {
    public List<Mail> loadMails(String databaseName);
}