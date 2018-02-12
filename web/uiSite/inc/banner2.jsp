<%--
<!doctype html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
--%>
  <link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
  <link rel="stylesheet" href="css/bannerStyle.css"> <!-- Resource style -->
  <script src="js/modernizr.js"></script> <!-- Modernizr -->
<section class="cd-hero">
  <ul class="cd-hero-slider autoplay">
    <li class="selected">
      <div class="cd-full-width">


      </div> <!-- .cd-full-width -->
    </li>
<%--
    <li>
      <div class="cd-half-width">
       &lt;%&ndash; <h2>早年经历</h2>
        <p>1994年~1997年，就读于台北市立金华国民中学。</p>
        <a  class="cd-btn">查看更多</a>&ndash;%&gt;

      </div> <!-- .cd-half-width -->

      <div class="cd-half-width cd-img-container">
        <img src="images/banner1.jpg" alt="tech 1">
      </div> <!-- .cd-half-width.cd-img-container -->
    </li>

    <li>
      <div class="cd-half-width cd-img-container">
        <img src="assets/tech-2.jpg" alt="tech 2">
      </div> <!-- .cd-half-width.cd-img-container -->

      <div class="cd-half-width">
        &lt;%&ndash;<h2>参演短片</h2>
        <p>五月天音乐概念电影</p>
        <a  class="cd-btn">查看更多</a>&ndash;%&gt;
      </div> <!-- .cd-half-width -->

    </li>

    <li class="cd-bg-video">
      <div class="cd-full-width">
        &lt;%&ndash;<h2>演艺经历</h2>
        <p>入行初期，张钧甯主要以拍摄音乐录影带和广告为主。</p>
        <a  class="cd-btn">查看更多</a>&ndash;%&gt;
      </div> <!-- .cd-full-width -->

      <div class="cd-bg-video-wrapper" data-video="assets/video/video">
        <!-- video element will be loaded using jQuery -->
      </div> <!-- .cd-bg-video-wrapper -->
    </li>--%>
      <%
        int p=0;
        for (Advertisement ad :ads){
          p++;
      %>
      <li style="background-image: url('../upload/adv/<%=ad.getImage()%>');">
        <div class="cd-full-width">
          <%-- <h2>个人生活</h2>
           <p>张钧甯的父亲是台大法学教授，母亲是儿童作家， 她与姐姐张瀛都在德国出生。</p>
           <a  class="cd-btn">查看更多</a>--%>
        </div>
      </li>
      <%
        }
      %>
  </ul> <!-- .cd-hero-slider -->

  <div class="cd-slider-nav">
    <nav>
      <span class="cd-marker item-1"></span>

      <ul>
        <li class="selected"><a href="#0">1</a></li>
        <%
          for (int k=0;k<p;k++){
        %>
        <li><a href="#0"><%=k+2%></a></li>
        <%
          }
        %>
       <%-- <li><a href="#0">Quick</a></li>
        <li><a href="#0">Security</a></li>
        <li><a href="#0">Sincerity</a></li>--%>
      </ul>
    </nav>
  </div> <!-- .cd-slider-nav -->
</section> <!-- .cd-hero -->

<script src="js/jquery.js"></script>
<script src="js/bannermain.js"></script> <!-- Resource jQuery -->
<script>

</script>

