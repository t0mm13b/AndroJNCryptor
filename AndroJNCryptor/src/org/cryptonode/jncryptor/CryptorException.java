/*    Copyright 2013 Duncan Jones
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cryptonode.jncryptor;

/**
 * An exception thrown when an error occurs encrypting or decrypting.
 */
public class CryptorException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new exception.
   */
  public CryptorException() {
  }

  /**
   * Constructs a new exception.
   * 
   * @param message
   *          error message
   */
  public CryptorException(String message) {
    super(message);
  }

  /**
   * Constructs a new exception.
   * 
   * @param cause
   *          the cause of the exception
   */
  public CryptorException(Throwable cause) {
    super(cause);
  }

  /**
   * Constructs a new exception.
   * 
   * @param message
   *          error message
   * @param cause
   *          the cause of the exception
   */
  public CryptorException(String message, Throwable cause) {
    super(message, cause);
  }
}
