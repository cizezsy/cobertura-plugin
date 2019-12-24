package hudson.plugins.cobertura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IOUtilsTest {

  @Test
  public void testSanitizeRelativePathInUnix() {
    String fileName = "../aaa/bbb";
    String sanitizedName = IOUtils.sanitizeFilename(fileName);

    assertEquals("__aaa_bbb", sanitizedName);

    fileName = "aaa/../bbb";
    sanitizedName = IOUtils.sanitizeFilename(fileName);

    assertEquals("aaa___bbb", sanitizedName);
  }

  @Test
  public void testSanitizeRelativePathInWindows() {
    String fileName = "..\\aaa\\bbb";
    String sanitizedName = IOUtils.sanitizeFilename(fileName);

    assertEquals("__aaa_bbb", sanitizedName);

    fileName = "aaa\\..\\bbb";
    sanitizedName = IOUtils.sanitizeFilename(fileName);
    assertEquals( "aaa___bbb", sanitizedName);
  }


  @Test
  public void testSanitizeAbsolutePathInUnix() {
    String fileName = "/aaa/bbb";
    String sanitizedFileName = IOUtils.sanitizeFilename(fileName);

    assertEquals("_aaa_bbb", sanitizedFileName);
  }

  @Test
  public void testSanitizeAbsolutePathInWindows() {
    String fileName = "C:\\aaa\\bbb";
    String sanitizedName = IOUtils.sanitizeFilename(fileName);

    assertEquals("C__aaa_bbb", sanitizedName);
  }
}
