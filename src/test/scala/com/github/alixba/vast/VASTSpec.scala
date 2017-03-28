package com.github.alixba.vast

import org.scalatest.{ Matchers, WordSpec }

import scala.xml.Node

class VASTSpec extends WordSpec with Matchers with Fixtures {

  "VAST library" should {

    "serialize and deserialize correctly" in {
      val vastStrOneLined = compressStr(vastStr)
      val vastStr2OneLined: String = compressStr(VAST.fromString(vastStr).toXML.toString())
      vastStr2OneLined shouldEqual vastStrOneLined
    }
  }

}

trait Fixtures {

  def compressStr(str: String): String =
    str.filter(_ != '\n').replaceAll(" +", "")

  val vastStr =
    """
      |<VAST version="string">
      |  <Ad id="string" sequence="100">
      |    <InLine>
      |      <AdSystem version="string">string</AdSystem>
      |      <AdTitle>string</AdTitle>
      |      <Description>string</Description>
      |      <Advertiser>string</Advertiser>
      |      <Pricing model="cpe" currency="string">1000.0</Pricing>
      |      <Survey><![CDATA[http://www.company.org/sonoras/aeoliam?test=test&test=test]]></Survey>
      |      <Error><![CDATA[http://www.any.com/verrantque/temperat]]></Error>
      |      <Impression id="string"><![CDATA[http://www.any.com/circum/regemque]]></Impression>
      |      <Creatives>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <Linear skipoffset="string">
      |            <Icons>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="09:01:03+01:00" duration="17:46:32+02:00" apiFramework="string">
      |                <StaticResource creativeType="string"><![CDATA[http://www.corp.org/regina/montis]]></StaticResource>
      |                <IconClicks>
      |                  <IconClickTracking><![CDATA[http://www.test.edu/rapidum/ac]]></IconClickTracking>
      |                  <IconClickThrough><![CDATA[http://www.my.org/circum/aris]]></IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking><![CDATA[http://www.sample.org/arce/claustra]]></IconViewTracking>
      |              </Icon>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="09:01:03+01:00" duration="17:46:32+02:00" apiFramework="string">
      |                <IFrameResource><![CDATA[http://www.sample.com/bella/nubibus]]></IFrameResource>
      |                <IconClicks>
      |                  <IconClickTracking><![CDATA[http://www.test.edu/rapidum/ac]]></IconClickTracking>
      |                  <IconClickThrough><![CDATA[http://www.my.org/circum/aris]]></IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking><![CDATA[http://www.sample.org/arce/claustra]]></IconViewTracking>
      |              </Icon>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="09:01:03+01:00" duration="17:46:32+02:00" apiFramework="string">
      |                <HTMLResource xmlEncoded="false">string</HTMLResource>
      |                <IconClicks>
      |                  <IconClickTracking><![CDATA[http://www.test.edu/rapidum/ac]]></IconClickTracking>
      |                  <IconClickThrough><![CDATA[http://www.my.org/circum/aris]]></IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking><![CDATA[http://www.sample.org/arce/claustra]]></IconViewTracking>
      |              </Icon>
      |            </Icons>
      |            <CreativeExtensions>
      |              <CreativeExtension>
      |                <AnyElement/>
      |              </CreativeExtension>
      |            </CreativeExtensions>
      |            <Duration>02:36:55+02:00</Duration>
      |            <TrackingEvents>
      |              <Tracking event="close" offset="string"><![CDATA[http://www.company.gov/feta/ac]]></Tracking>
      |              <Tracking event="customEvent" offset="string"><![CDATA[http://www.company.gov/feta/ac]]></Tracking>
      |            </TrackingEvents>
      |            <AdParameters xmlEncoded="false">string</AdParameters>
      |            <VideoClicks>
      |              <ClickThrough id="string"><![CDATA[http://www.test.org/pectore/austris]]></ClickThrough>
      |              <ClickTracking id="string"><![CDATA[http://www.your.gov/certo/dare]]></ClickTracking>
      |              <CustomClick id="string"><![CDATA[http://www.any.com/volutans/dedit]]></CustomClick>
      |            </VideoClicks>
      |            <MediaFiles>
      |              <MediaFile id="string" delivery="streaming" type="string" bitrate="100" minBitrate="100" maxBitrate="100" width="100" height="100" scalable="true" maintainAspectRatio="true" apiFramework="string" codec="string"><![CDATA[http://www.test.gov/regemque/annos]]></MediaFile>
      |            </MediaFiles>
      |          </Linear>
      |        </Creative>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <CompanionAds required="none">
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <StaticResource creativeType="string"><![CDATA[http://www.corp.org/regina/montis]]></StaticResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string"><![CDATA[http://www.corp.com/abdidit/iunonis]]></Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough><![CDATA[http://www.any.gov/ipsa/illum]]></CompanionClickThrough>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </Companion>
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <IFrameResource><![CDATA[http://www.sample.com/insuper/mollitque]]></IFrameResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string"><![CDATA[http://www.corp.com/abdidit/iunonis]]></Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough><![CDATA[http://www.any.gov/ipsa/illum]]></CompanionClickThrough>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </Companion>
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <HTMLResource xmlEncoded="false">string</HTMLResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string"><![CDATA[http://www.corp.com/abdidit/iunonis]]></Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough><![CDATA[http://www.any.gov/ipsa/illum]]></CompanionClickThrough>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </Companion>
      |          </CompanionAds>
      |        </Creative>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <NonLinearAds>
      |            <TrackingEvents>
      |              <Tracking event="expand" offset="string"><![CDATA[http://www.my.com/mollitque/premere]]></Tracking>
      |            </TrackingEvents>
      |            <NonLinear id="string" width="100" height="100" expandedWidth="100" expandedHeight="100" scalable="false" maintainAspectRatio="false" minSuggestedDuration="07:47:05+01:00" apiFramework="string">
      |              <StaticResource creativeType="string"><![CDATA[http://www.test.org/vasto/montis]]></StaticResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <NonLinearClickTracking><![CDATA[http://www.your.org/ac/iras]]></NonLinearClickTracking>
      |              <NonLinearClickThrough><![CDATA[http://www.company.com/et/austris]]></NonLinearClickThrough>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </NonLinear>
      |            <NonLinear id="string" width="100" height="100" expandedWidth="100" expandedHeight="100" scalable="false" maintainAspectRatio="false" minSuggestedDuration="07:47:05+01:00" apiFramework="string">
      |              <IFrameResource><![CDATA[http://www.sample.org/tempestatesque/aris]]></IFrameResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <NonLinearClickTracking><![CDATA[http://www.your.org/ac/iras]]></NonLinearClickTracking>
      |              <NonLinearClickThrough><![CDATA[http://www.company.com/et/austris]]></NonLinearClickThrough>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </NonLinear>
      |            <NonLinear id="string" width="100" height="100" expandedWidth="100" expandedHeight="100" scalable="false" maintainAspectRatio="false" minSuggestedDuration="07:47:05+01:00" apiFramework="string">
      |              <HTMLResource xmlEncoded="true">string</HTMLResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <NonLinearClickTracking><![CDATA[http://www.your.org/ac/iras]]></NonLinearClickTracking>
      |              <NonLinearClickThrough><![CDATA[http://www.company.com/et/austris]]></NonLinearClickThrough>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </NonLinear>
      |          </NonLinearAds>
      |        </Creative>
      |      </Creatives>
      |      <Extensions>
      |        <Extension>
      |          <AnyElement/>
      |        </Extension>
      |      </Extensions>
      |    </InLine>
      |  </Ad>
      |  <Ad>
      |    <Wrapper>
      |      <AdSystem version="string">string</AdSystem>
      |      <VASTAdTagURI><![CDATA[http://www.my.com/atris/imposuit]]></VASTAdTagURI>
      |      <Error><![CDATA[http://www.my.com/animos/iras]]></Error>
      |      <Impression><![CDATA[http://www.corp.org/patriam/metuens]]></Impression>
      |      <Creatives>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <Linear>
      |            <CreativeExtensions>
      |              <CreativeExtension>
      |                <AnyElement/>
      |              </CreativeExtension>
      |            </CreativeExtensions>
      |            <Icons>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="00:17:14" duration="21:57:51+02:00" apiFramework="string">
      |                <StaticResource creativeType="string"><![CDATA[http://www.test.org/murmure/coniunx]]></StaticResource>
      |                <IconClicks>
      |                  <IconClickTracking><![CDATA[http://www.corp.com/aequora/luctantis]]></IconClickTracking>
      |                  <IconClickThrough><![CDATA[http://www.sample.org/et/aris]]></IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking><![CDATA[http://www.my.com/hic/arce]]></IconViewTracking>
      |              </Icon>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="00:17:14" duration="21:57:51+02:00" apiFramework="string">
      |                <IFrameResource><![CDATA[http://www.test.org/rapidi/turbine]]></IFrameResource>
      |                <IconClicks>
      |                  <IconClickTracking><![CDATA[http://www.corp.com/aequora/luctantis]]></IconClickTracking>
      |                  <IconClickThrough><![CDATA[http://www.sample.org/et/aris]]></IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking><![CDATA[http://www.my.com/hic/arce]]></IconViewTracking>
      |              </Icon>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="00:17:14" duration="21:57:51+02:00" apiFramework="string">
      |                <HTMLResource xmlEncoded="true">string</HTMLResource>
      |                <IconClicks>
      |                  <IconClickTracking><![CDATA[http://www.corp.com/aequora/luctantis]]></IconClickTracking>
      |                  <IconClickThrough><![CDATA[http://www.sample.org/et/aris]]></IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking><![CDATA[http://www.my.com/hic/arce]]></IconViewTracking>
      |              </Icon>
      |            </Icons>
      |            <TrackingEvents>
      |              <Tracking event="fullscreen" offset="string"><![CDATA[http://www.corp.com/circum/ego]]></Tracking>
      |            </TrackingEvents>
      |            <VideoClicks>
      |              <ClickThrough id="string"><![CDATA[http://www.test.org/pectore/austris]]></ClickThrough>
      |              <ClickTracking id="string"><![CDATA[http://www.any.org/insuper/molemque]]></ClickTracking>
      |              <CustomClick id="string"><![CDATA[http://www.my.org/magno/nimborum]]></CustomClick>
      |            </VideoClicks>
      |          </Linear>
      |        </Creative>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <CompanionAds>
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <StaticResource creativeType="string"><![CDATA[http://www.company.com/iunonis/aeoliam]]></StaticResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string"><![CDATA[http://www.any.org/rates/maria]]></Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough><![CDATA[http://www.sample.org/ipsa/numen]]></CompanionClickThrough>
      |              <CompanionClickTracking><![CDATA[http://www.your.org/maria/et]]></CompanionClickTracking>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="false">string</AdParameters>
      |            </Companion>
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <IFrameResource><![CDATA[http://www.your.org/iovisque/et]]></IFrameResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string"><![CDATA[http://www.any.org/rates/maria]]></Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough><![CDATA[http://www.sample.org/ipsa/numen]]></CompanionClickThrough>
      |              <CompanionClickTracking><![CDATA[http://www.your.org/maria/et]]></CompanionClickTracking>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="false">string</AdParameters>
      |            </Companion>
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <HTMLResource xmlEncoded="true">string</HTMLResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string"><![CDATA[http://www.any.org/rates/maria]]></Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough><![CDATA[http://www.sample.org/ipsa/numen]]></CompanionClickThrough>
      |              <CompanionClickTracking><![CDATA[http://www.your.org/maria/et]]></CompanionClickTracking>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="false">string</AdParameters>
      |            </Companion>
      |          </CompanionAds>
      |        </Creative>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <NonLinearAds>
      |            <TrackingEvents>
      |              <Tracking event="rewind" offset="string"><![CDATA[http://www.company.edu/rapidi/iaculata]]></Tracking>
      |            </TrackingEvents>
      |            <NonLinear id="string" width="100" height="100" expandedWidth="100" expandedHeight="100" scalable="true" maintainAspectRatio="true" minSuggestedDuration="12:18:29+01:00" apiFramework="string">
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <NonLinearClickTracking><![CDATA[http://www.company.com/terras/vasto]]></NonLinearClickTracking>
      |            </NonLinear>
      |          </NonLinearAds>
      |        </Creative>
      |      </Creatives>
      |      <Extensions>
      |        <Extension>
      |          <AnyElement/>
      |        </Extension>
      |      </Extensions>
      |    </Wrapper>
      |  </Ad>
      |</VAST>
    """.stripMargin

}
