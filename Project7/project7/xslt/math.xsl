<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html xmlns="http://www.w3.org/1999/xhtml">
      <body>
	<h2>MATH courses Title</h2>
	<table border="1">
	  <tr bgcolor="green">
            <th>Name</th>
            <th>Registration Number</th>
            <th>Subject</th>
            <th>Course</th>
            <th>Section</th>
			<th>Units</th>
            <th>Instructor</th>
            <th>Days</th>
			<th>Time</th>
			<th>Place</th>
	  </tr>
	  <xsl:for-each select="//course[subj='MATH']">
	    <tr>
	      <td><xsl:value-of select="title"/></td>
	      <td><xsl:value-of select="reg_num"/></td>
	     
	      <td><xsl:value-of select="subj"/></td>
	      <td><xsl:value-of select="crse"/></td>
		  <td><xsl:value-of select="sect"/></td>
		  <td><xsl:value-of select="units"/></td>
		  <td><xsl:value-of select="instructor"/></td>
		  <td><xsl:value-of select="days"/></td>
		   <td>
		<xsl:value-of select="time/start_time"/>,
		<xsl:value-of select="time/end_time"/>
	      </td>
		  <td>
		<xsl:value-of select="place/building"/>,
		<xsl:value-of select="place/room"/>
	      </td>
	      <!-- <td><xsl:value-of select="url"/></td> -->
	    </tr>
	  </xsl:for-each>
	</table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
