<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <h1>Testing xsl</h1>
        <xsl:for-each select="//*[local-name()='Course']">
            <div class="course_item">
                <p>Id=<xsl:value-of select="*[local-name()='Id']"/>
                </p>
                <p>Name=<xsl:value-of select="*[local-name()='Name']"/>
                </p>
                <p>Author=<xsl:value-of select="*[local-name()='Author']"/>
                </p>
                <p>AuthorDescription=<xsl:value-of select="*[local-name()='AuthorDescription']" disable-output-escaping="yes"/>
                </p>
                <p>DomainId=<xsl:value-of select="*[local-name()='DomainId']"/>
                </p>
                <p>CategoryId=<xsl:value-of select="*[local-name()='CategoryId']"/>
                </p>
                <p>OverviewDescription=<xsl:value-of select="*[local-name()='OverviewDescription']" disable-output-escaping="yes"/>
                </p>
                <p>AuthorImageURL=<xsl:value-of select="*[local-name()='AuthorImageURL']"/>
                </p>
                <p>Rating=<xsl:value-of select="*[local-name()='Rating']"/>
                </p>
                <p>RatingNumber=<xsl:value-of select="*[local-name()='RatingNumber']"/>
                </p>
                <p>Cost=<xsl:value-of select="*[local-name()='Cost']"/>
                </p>
                <p>Duration=<xsl:value-of select="*[local-name()='Duration']"/>
                </p>
                <p>Syllabus=<xsl:value-of select="*[local-name()='Syllabus']" disable-output-escaping="yes"/>
                </p>
                <p>PreviewVideoURL=<xsl:value-of select="*[local-name()='PreviewVideoURL']"/>
                </p>
                <p>ImageURL=<xsl:value-of select="*[local-name()='ImageURL']"/>
                </p>
                <p>SourceURL=<xsl:value-of select="*[local-name()='SourceURL']"/>
                </p>
                <p>Hash=<xsl:value-of select="*[local-name()='Hash']"/>
                </p>
            </div>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>