/*
 * Copyright (C) 2014 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zxing.pdf417.encoder;

import java.nio.charset.Charset;
import org.junit.Assert;
import org.junit.Test;

public final class PDF417EncoderTestCase extends Assert {
    
  private static final Charset UTF8 = Charset.forName("UTF-8");

  @Test
  public void testEncodeAuto() throws Exception {
    String encoded = PDF417HighLevelEncoder.encodeHighLevel(
        "ABCD", Compaction.AUTO, UTF8);
    assertEquals("\u039f\u001A\u0385ABCD", encoded);
  }

  @Test
  public void testEncodeText() throws Exception {
    String encoded = PDF417HighLevelEncoder.encodeHighLevel(
        "ABCD", Compaction.TEXT, UTF8);
    assertEquals("Ο\u001A\u0001?", encoded);
  }

  @Test
  public void testEncodeNumeric() throws Exception {
    String encoded = PDF417HighLevelEncoder.encodeHighLevel(
        "1234", Compaction.NUMERIC, UTF8);
    assertEquals("\u039f\u001A\u0386\f\u01b2", encoded);
  }

  @Test
  public void testEncodeByte() throws Exception {
    String encoded = PDF417HighLevelEncoder.encodeHighLevel(
        "abcd", Compaction.BYTE, UTF8);
    assertEquals("\u039f\u001A\u0385abcd", encoded);
  }

}
