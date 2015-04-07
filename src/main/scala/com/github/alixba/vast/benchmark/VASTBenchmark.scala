package com.github.alixba.vast.benchmark

import com.github.alixba.vast.VAST
import org.openjdk.jmh.annotations._
import java.util.concurrent.TimeUnit

import scala.xml.Node

@State(Scope.Thread)
private[benchmark] class VASTBenchmark {

  @Benchmark
  @BenchmarkMode(Array(Mode.AverageTime))
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  def fromString(): VAST = {
    VAST.fromString(vastStr)
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.AverageTime))
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  def toXML: Node = {
    vastObject.toXML
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.AverageTime))
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  def toStr: String = {
    vastXML.toString()
  }

  val vastStr =
    """
      |<VAST version="string">
      |  <Ad id="string" sequence="100">
      |    <InLine>
      |      <AdSystem version="string">string</AdSystem>
      |      <AdTitle>string</AdTitle>
      |      <Description>string</Description>
      |      <Advertiser>string</Advertiser>
      |      <Pricing model="cpe" currency="string">1000.00</Pricing>
      |      <Survey><![CDATA[http://www.company.org/sonoras/aeoliam?test=test&test=test]]></Survey>
      |      <Error>http://www.any.com/verrantque/temperat</Error>
      |      <Impression id="string">http://www.any.com/circum/regemque</Impression>
      |      <Creatives>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <Linear skipoffset="string">
      |            <Icons>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="09:01:03+01:00" duration="17:46:32+02:00" apiFramework="string">
      |                <StaticResource creativeType="string">http://www.corp.org/regina/montis</StaticResource>
      |                <IconClicks>
      |                  <IconClickTracking>http://www.test.edu/rapidum/ac</IconClickTracking>
      |                  <IconClickThrough>http://www.my.org/circum/aris</IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking>http://www.sample.org/arce/claustra</IconViewTracking>
      |              </Icon>
      |            </Icons>
      |            <Icons>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="09:01:03+01:00" duration="17:46:32+02:00" apiFramework="string">
      |                <IFrameResource>http://www.sample.com/bella/nubibus</IFrameResource>
      |                <IconClicks>
      |                  <IconClickTracking>http://www.test.edu/rapidum/ac</IconClickTracking>
      |                  <IconClickThrough>http://www.my.org/circum/aris</IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking>http://www.sample.org/arce/claustra</IconViewTracking>
      |              </Icon>
      |            </Icons>
      |            <Icons>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="09:01:03+01:00" duration="17:46:32+02:00" apiFramework="string">
      |                <HTMLResource xmlEncoded="false">string</HTMLResource>
      |                <IconClicks>
      |                  <IconClickTracking>http://www.test.edu/rapidum/ac</IconClickTracking>
      |                  <IconClickThrough>http://www.my.org/circum/aris</IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking>http://www.sample.org/arce/claustra</IconViewTracking>
      |              </Icon>
      |            </Icons>
      |            <CreativeExtensions>
      |              <CreativeExtension>
      |                <AnyElement/>
      |              </CreativeExtension>
      |            </CreativeExtensions>
      |            <Duration>02:36:55+02:00</Duration>
      |            <TrackingEvents>
      |              <Tracking event="close" offset="string">http://www.company.gov/feta/ac</Tracking>
      |            </TrackingEvents>
      |            <AdParameters xmlEncoded="false">string</AdParameters>
      |            <VideoClicks>
      |              <ClickThrough id="string">http://www.test.org/pectore/austris</ClickThrough>
      |              <ClickTracking id="string">http://www.your.gov/certo/dare</ClickTracking>
      |              <CustomClick id="string">http://www.any.com/volutans/dedit</CustomClick>
      |            </VideoClicks>
      |            <MediaFiles>
      |              <MediaFile id="string" delivery="streaming" type="string" bitrate="100" minBitrate="100" maxBitrate="100" width="100" height="100" scalable="true" maintainAspectRatio="true" apiFramework="string" codec="string">http://www.test.gov/regemque/annos</MediaFile>
      |            </MediaFiles>
      |          </Linear>
      |        </Creative>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <CompanionAds required="none">
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <StaticResource creativeType="string">http://www.corp.org/regina/montis</StaticResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string">http://www.corp.com/abdidit/iunonis</Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough>http://www.any.gov/ipsa/illum</CompanionClickThrough>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </Companion>
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <IFrameResource>http://www.sample.com/insuper/mollitque</IFrameResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string">http://www.corp.com/abdidit/iunonis</Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough>http://www.any.gov/ipsa/illum</CompanionClickThrough>
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
      |                <Tracking event="creativeView" offset="string">http://www.corp.com/abdidit/iunonis</Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough>http://www.any.gov/ipsa/illum</CompanionClickThrough>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </Companion>
      |          </CompanionAds>
      |        </Creative>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <NonLinearAds>
      |            <TrackingEvents>
      |              <Tracking event="expand" offset="string">http://www.my.com/mollitque/premere</Tracking>
      |            </TrackingEvents>
      |            <NonLinear id="string" width="100" height="100" expandedWidth="100" expandedHeight="100" scalable="false" maintainAspectRatio="false" minSuggestedDuration="07:47:05+01:00" apiFramework="string">
      |              <StaticResource creativeType="string">http://www.test.org/vasto/montis</StaticResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <NonLinearClickTracking>http://www.your.org/ac/iras</NonLinearClickTracking>
      |              <NonLinearClickThrough>http://www.company.com/et/austris</NonLinearClickThrough>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </NonLinear>
      |            <NonLinear id="string" width="100" height="100" expandedWidth="100" expandedHeight="100" scalable="false" maintainAspectRatio="false" minSuggestedDuration="07:47:05+01:00" apiFramework="string">
      |              <IFrameResource>http://www.sample.org/tempestatesque/aris</IFrameResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <NonLinearClickTracking>http://www.your.org/ac/iras</NonLinearClickTracking>
      |              <NonLinearClickThrough>http://www.company.com/et/austris</NonLinearClickThrough>
      |              <AdParameters xmlEncoded="true">string</AdParameters>
      |            </NonLinear>
      |            <NonLinear id="string" width="100" height="100" expandedWidth="100" expandedHeight="100" scalable="false" maintainAspectRatio="false" minSuggestedDuration="07:47:05+01:00" apiFramework="string">
      |              <HTMLResource xmlEncoded="true">string</HTMLResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <NonLinearClickTracking>http://www.your.org/ac/iras</NonLinearClickTracking>
      |              <NonLinearClickThrough>http://www.company.com/et/austris</NonLinearClickThrough>
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
      |      <VASTAdTagURI>http://www.my.com/atris/imposuit</VASTAdTagURI>
      |      <Error>http://www.my.com/animos/iras</Error>
      |      <Impression>http://www.corp.org/patriam/metuens</Impression>
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
      |                <StaticResource creativeType="string">http://www.test.org/murmure/coniunx</StaticResource>
      |                <IconClicks>
      |                  <IconClickTracking>http://www.corp.com/aequora/luctantis</IconClickTracking>
      |                  <IconClickThrough>http://www.sample.org/et/aris</IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking>http://www.my.com/hic/arce</IconViewTracking>
      |              </Icon>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="00:17:14" duration="21:57:51+02:00" apiFramework="string">
      |                <IFrameResource>http://www.test.org/rapidi/turbine</IFrameResource>
      |                <IconClicks>
      |                  <IconClickTracking>http://www.corp.com/aequora/luctantis</IconClickTracking>
      |                  <IconClickThrough>http://www.sample.org/et/aris</IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking>http://www.my.com/hic/arce</IconViewTracking>
      |              </Icon>
      |              <Icon program="string" width="100" height="100" xPosition="string" yPosition="string" offset="00:17:14" duration="21:57:51+02:00" apiFramework="string">
      |                <HTMLResource xmlEncoded="true">string</HTMLResource>
      |                <IconClicks>
      |                  <IconClickTracking>http://www.corp.com/aequora/luctantis</IconClickTracking>
      |                  <IconClickThrough>http://www.sample.org/et/aris</IconClickThrough>
      |                </IconClicks>
      |                <IconViewTracking>http://www.my.com/hic/arce</IconViewTracking>
      |              </Icon>
      |            </Icons>
      |            <TrackingEvents>
      |              <Tracking event="fullscreen" offset="string">http://www.corp.com/circum/ego</Tracking>
      |            </TrackingEvents>
      |            <VideoClicks>
      |              <ClickTracking id="string">http://www.any.org/insuper/molemque</ClickTracking>
      |              <CustomClick id="string">http://www.my.org/magno/nimborum</CustomClick>
      |            </VideoClicks>
      |          </Linear>
      |        </Creative>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <CompanionAds>
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <StaticResource creativeType="string">http://www.company.com/iunonis/aeoliam</StaticResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string">http://www.any.org/rates/maria</Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough>http://www.sample.org/ipsa/numen</CompanionClickThrough>
      |              <CompanionClickTracking>http://www.your.org/maria/et</CompanionClickTracking>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="false">string</AdParameters>
      |            </Companion>
      |            <Companion id="string" width="100" height="100" assetWidth="100" assetHeight="100" expandedWidth="100" expandedHeight="100" apiFramework="string" adSlotId="string">
      |              <IFrameResource>http://www.your.org/iovisque/et</IFrameResource>
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <TrackingEvents>
      |                <Tracking event="creativeView" offset="string">http://www.any.org/rates/maria</Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough>http://www.sample.org/ipsa/numen</CompanionClickThrough>
      |              <CompanionClickTracking>http://www.your.org/maria/et</CompanionClickTracking>
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
      |                <Tracking event="creativeView" offset="string">http://www.any.org/rates/maria</Tracking>
      |              </TrackingEvents>
      |              <CompanionClickThrough>http://www.sample.org/ipsa/numen</CompanionClickThrough>
      |              <CompanionClickTracking>http://www.your.org/maria/et</CompanionClickTracking>
      |              <AltText>string</AltText>
      |              <AdParameters xmlEncoded="false">string</AdParameters>
      |            </Companion>
      |          </CompanionAds>
      |        </Creative>
      |        <Creative id="string" sequence="100" AdID="string">
      |          <NonLinearAds>
      |            <TrackingEvents>
      |              <Tracking event="rewind" offset="string">http://www.company.edu/rapidi/iaculata</Tracking>
      |            </TrackingEvents>
      |            <NonLinear id="string" width="100" height="100" expandedWidth="100" expandedHeight="100" scalable="true" maintainAspectRatio="true" minSuggestedDuration="12:18:29+01:00" apiFramework="string">
      |              <CreativeExtensions>
      |                <CreativeExtension>
      |                  <AnyElement/>
      |                </CreativeExtension>
      |              </CreativeExtensions>
      |              <NonLinearClickTracking>http://www.company.com/terras/vasto</NonLinearClickTracking>
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

  val vastObject = VAST.fromString(vastStr)

  val vastXML = vastObject.toXML

}