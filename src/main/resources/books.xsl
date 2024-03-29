<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simple">
                    <fo:region-body margin="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simple">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="12pt" font-family="sans-serif">
                        <xsl:for-each select="books/book">
                            <fo:block>
                                Title: <xsl:value-of select="title"/>
                            </fo:block>
                            <fo:block>
                                Author: <xsl:value-of select="author"/>
                            </fo:block>
                            <fo:block>
                                Year: <xsl:value-of select="year"/>
                            </fo:block>
                            <fo:block space-after="10pt"/>
                        </xsl:for-each>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>
