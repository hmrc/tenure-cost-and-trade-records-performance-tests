#!/usr/bin/env bash
sbt -DrunLocal=false -Dperftest.runSmokeTest=false Gatling/test

=========================
Session:
Session(user submits 6011 form,5,HashMap(bfce7a4e-47f0-422e-9632-25a577cc2767 -> 0, random -> 864146711, gatling.http.cache.dns -> io.gatling.http.resolver.ShufflingNameResolver@768f3fae, currentTime -> 1696849921039, gatling.http.ssl.sslContexts -> io.gatling.http.util.SslContexts@610b2630, gatling.http.referer -> https://www.staging.tax.service.gov.uk/send-trade-and-cost-information/login, csrfToken -> 0e5e6725712cf05e63c087eee50167f576af5c7b-1696849921302-ae91bb27859d92bc5c9729b4, gatling.http.cookies -> CookieJar(Map(CookieKey(mdtpdi,www.staging.tax.service.gov.uk,/) -> StoredCookie(mdtpdi=mdtpdi#f00c953c-1334-45b5-b45d-1e5941d39399#1696849921209_woqSWk+/WNROg4zlbzE2BQ==, path=/, maxAge=315360000s, secure, HTTPOnly,true,true,1696849367648), CookieKey(mdtp,www.staging.tax.service.gov.uk,/) -> StoredCookie(mdtp=84Hc+eu+48QzlPDwI2pPmKmMWWEu+12cseBtKBwpSyCMrTrGJC/3ovYc9GJXs/z4EB8gX78Vgc73cmHb55+ClS0TqcUDFmNIIs33MVJ73nF+Ast4VPTfWreXAGYOX0/WGxn5SITWeL4/WJ7VRMEAcx4TLfd6uMQVPZHw9nM2IMXa/rnWai2n1DqTaRFfooG0T2V+79wZ/CnuZo07EzVN4ZeclOWJ7vqvE4lHcAYHHHfiJS18SXEhdHfyb4BGD5kfMvA3SySzKUACQWIT4RM4h3yIG9c4CiV1BeNCm34tf8AjegWB6kj0x9d7, path=/, secure, HTTPOnly, SameSite=Lax,true,false,1696849367648)))),OK,List(GroupBlock(List(submit 6011 form),1696849367329,296,KO), TryMaxBlock(bfce7a4e-47f0-422e-9632-25a577cc2767,io.gatling.core.action.InnerTryMax@6ba322a,KO)),io.gatling.core.protocol.ProtocolComponentsRegistry$$Lambda$580/0x00000008005d3840@586ea69d,io.netty.channel.nio.NioEventLoop@571e14d3)
=========================
HTTP request:
POST https://www.staging.tax.service.gov.uk/send-trade-and-cost-information/login
headers:
	True-Client-IP: 864146711
	accept-language: en-gb,en;q=0.5
	accept-encoding: gzip, deflate
	accept: image/png,image/*;q=0.8,*/*;q=0.5
	user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:25.0) Gecko/20100101 Firefox/25.0
	referer: https://www.staging.tax.service.gov.uk/send-trade-and-cost-information/login
	cookie: mdtpdi=mdtpdi#f00c953c-1334-45b5-b45d-1e5941d39399#1696849921209_woqSWk+/WNROg4zlbzE2BQ==; mdtp=zqzs8Ifpl4S4Lq8nlUrOntca7ksfMF0KzmjkgIqcUDvIYvfNX5cwxNPnwIDzYPh7VOoIWLcGUdjEO7jWzD6XXiMp0ID477lFc1pgZLn505mgkJC/6vUmWJNXbI+coq1XZPxI7+wNtaU/paHTzBOhH99SIzOe6+2L3U+Wr4uxxnp74BVXE/7ssAl3vjfTC4o0KhLbgH77dD+w9+NxfRSaFqKJ5RTHVRc/uvywv912JbXd4gtGk9mKiw/Aau+eFDNKO+csl7jf9LE1Ft5xf50y7WyJA2bxfWY2QP3Npi+gBeE8HCp2u7vawgyl
	origin: https://www.staging.tax.service.gov.uk
	host: www.staging.tax.service.gov.uk
	content-type: application/x-www-form-urlencoded
	content-length: 155
cookies: