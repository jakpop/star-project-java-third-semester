/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author pc
 */
public class AppendableObjectInputStream extends ObjectInputStream {
    public AppendableObjectInputStream(InputStream in) throws Exception {
	super(in);
    }
  
  @Override
  protected void readStreamHeader() throws IOException {
    // do not write a header
  }
}
