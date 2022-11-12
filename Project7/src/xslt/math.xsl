<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html xmlns="http://www.w3.org/1999/xhtml">
      <body>
	<h2>MATH courses Title</h2>
	<table border="1">
	  <tr bgcolor="green">
            <th>Name</th>
            <!-- <th>Phone</th>
            <th>Address</th>
            <th>Office</th>
            <th>URL</th> -->
	  </tr>
	  <xsl:for-each select="//course[subj='MATH']">
	    <tr>
	      <td><xsl:value-of select="title"/></td>
	      <!-- <td><xsl:value-of select="phone"/></td>
	      <td>
		<xsl:value-of select="address/city"/>,
		<xsl:value-of select="address/state"/>
		<xsl:value-of select="address/zip"/>
	      </td>
	      <td><xsl:value-of select="office"/></td>
	      <td><xsl:value-of select="url"/></td> -->
	    </tr>
	  </xsl:for-each>
	</table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
