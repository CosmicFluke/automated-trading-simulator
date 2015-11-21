



<!DOCTYPE html>
<html lang="en" class="">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta name="viewport" content="width=1020">
    
    
    <title>project-team9-L5101/StrategyTest.java at master · csc301-fall-2015/project-team9-L5101</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub">
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub">
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png">
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png">
    <meta property="fb:app_id" content="1401488693436528">

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="csc301-fall-2015/project-team9-L5101" name="twitter:title" /><meta content="Contribute to project-team9-L5101 development by creating an account on GitHub." name="twitter:description" /><meta content="https://avatars0.githubusercontent.com/u/12700292?v=3&amp;s=400" name="twitter:image:src" />
      <meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://avatars0.githubusercontent.com/u/12700292?v=3&amp;s=400" property="og:image" /><meta content="csc301-fall-2015/project-team9-L5101" property="og:title" /><meta content="https://github.com/csc301-fall-2015/project-team9-L5101" property="og:url" /><meta content="Contribute to project-team9-L5101 development by creating an account on GitHub." property="og:description" />
      <meta name="browser-stats-url" content="https://api.github.com/_private/browser/stats">
    <meta name="browser-errors-url" content="https://api.github.com/_private/browser/errors">
    <link rel="assets" href="https://assets-cdn.github.com/">
    <link rel="web-socket" href="wss://live.github.com/_sockets/MTI4MDAzNjA6MDhkZDM1Y2E0NGRiODg3MDhkODA0YzM0ZWM0YjkyNDc6M2U3MTBlMjU2M2VkMGZjMzI3MDZiOGUxYTNkMzJmNDBkZmQ2MjA5NGIzNmY0OTA0ZTA1MTZiZmE0ZjNjOWUyYw==--b818661cbcaf713dec674c5ae4fe959b5ecf0898">
    <meta name="pjax-timeout" content="1000">
    <link rel="sudo-modal" href="/sessions/sudo_modal">

    <meta name="msapplication-TileImage" content="/windows-tile.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="selected-link" value="repo_source" data-pjax-transient>

    <meta name="google-site-verification" content="KT5gs8h0wvaagLKAVWq8bbeNwnZZK1r1XQysX3xurLU">
    <meta name="google-analytics" content="UA-3769691-2">

<meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" /><meta content="63E70739:3F5B:A0901F:564FB86C" name="octolytics-dimension-request_id" /><meta content="12800360" name="octolytics-actor-id" /><meta content="xshirl1027" name="octolytics-actor-login" /><meta content="72301f63a8c312497e3020ab1d1e6b833ff6a4a67ae3ca397321852ddad3c7c0" name="octolytics-actor-hash" />
<meta content="/&lt;user-name&gt;/&lt;repo-name&gt;/blob/show" data-pjax-transient="true" name="analytics-location" />
<meta content="Rails, view, blob#show" data-pjax-transient="true" name="analytics-event" />


  <meta class="js-ga-set" name="dimension1" content="Logged In">
    <meta class="js-ga-set" name="dimension4" content="New repo nav">




    <meta name="is-dotcom" content="true">
        <meta name="hostname" content="github.com">
    <meta name="user-login" content="xshirl1027">

      <link rel="mask-icon" href="https://assets-cdn.github.com/pinned-octocat.svg" color="#4078c0">
      <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico">

    <meta content="36eed64f27793ac9a69b334de78c9666bd83dbfe" name="form-nonce" />

    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github-a5cd3ca7fd58e0798f0bb47d237929891ef14116e2433d9c44001dfb2de3b57e.css" media="all" rel="stylesheet" />
    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github2-7048b51d8e88507e1babbe42418137bac3f5ef75f4b1957242327b23ebacd292.css" media="all" rel="stylesheet" />
    
    
    


    <meta http-equiv="x-pjax-version" content="654c933e36ae3b16e666cd53375543ca">

      
  <meta name="description" content="Contribute to project-team9-L5101 development by creating an account on GitHub.">
  <meta name="go-import" content="github.com/csc301-fall-2015/project-team9-L5101 git https://github.com/csc301-fall-2015/project-team9-L5101.git">

  <meta content="12700292" name="octolytics-dimension-user_id" /><meta content="csc301-fall-2015" name="octolytics-dimension-user_login" /><meta content="43788620" name="octolytics-dimension-repository_id" /><meta content="csc301-fall-2015/project-team9-L5101" name="octolytics-dimension-repository_nwo" /><meta content="false" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="43788620" name="octolytics-dimension-repository_network_root_id" /><meta content="csc301-fall-2015/project-team9-L5101" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/csc301-fall-2015/project-team9-L5101/commits/master.atom?token=AMNRaEoSE0tLjR_U_ijAKNDabTA7l5Wiks60XOrwwA%3D%3D" rel="alternate" title="Recent Commits to project-team9-L5101:master" type="application/atom+xml">

  </head>


  <body class="logged_in   env-production windows vis-private page-blob">
    <a href="#start-of-content" tabindex="1" class="accessibility-aid js-skip-to-content">Skip to content</a>

    
    
    



      <div class="header header-logged-in true" role="banner">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/" data-hotkey="g d" aria-label="Homepage" data-ga-click="Header, go to dashboard, icon:logo">
  <span class="mega-octicon octicon-mark-github"></span>
</a>


      <div class="site-search repo-scope js-site-search" role="search">
          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/csc301-fall-2015/project-team9-L5101/search" class="js-site-search-form" data-global-search-url="/search" data-repo-search-url="/csc301-fall-2015/project-team9-L5101/search" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
  <label class="js-chromeless-input-container form-control">
    <div class="scope-badge">This repository</div>
    <input type="text"
      class="js-site-search-focus js-site-search-field is-clearable chromeless-input"
      data-hotkey="s"
      name="q"
      placeholder="Search"
      aria-label="Search this repository"
      data-global-scope-placeholder="Search GitHub"
      data-repo-scope-placeholder="Search"
      tabindex="1"
      autocapitalize="off">
  </label>
</form>
      </div>

      <ul class="header-nav left" role="navigation">
        <li class="header-nav-item">
          <a href="/pulls" class="js-selected-navigation-item header-nav-link" data-ga-click="Header, click, Nav menu - item:pulls context:user" data-hotkey="g p" data-selected-links="/pulls /pulls/assigned /pulls/mentioned /pulls">
            Pull requests
</a>        </li>
        <li class="header-nav-item">
          <a href="/issues" class="js-selected-navigation-item header-nav-link" data-ga-click="Header, click, Nav menu - item:issues context:user" data-hotkey="g i" data-selected-links="/issues /issues/assigned /issues/mentioned /issues">
            Issues
</a>        </li>
          <li class="header-nav-item">
            <a class="header-nav-link" href="https://gist.github.com/" data-ga-click="Header, go to gist, text:gist">Gist</a>
          </li>
      </ul>

    
<ul class="header-nav user-nav right" id="user-links">
  <li class="header-nav-item">
      <span class="js-socket-channel js-updatable-content"
        data-channel="notification-changed:xshirl1027"
        data-url="/notifications/header">
      <a href="/notifications" aria-label="You have unread notifications" class="header-nav-link notification-indicator tooltipped tooltipped-s" data-ga-click="Header, go to notifications, icon:unread" data-hotkey="g n">
          <span class="mail-status unread"></span>
          <span class="octicon octicon-bell"></span>
</a>  </span>

  </li>

  <li class="header-nav-item dropdown js-menu-container">
    <a class="header-nav-link tooltipped tooltipped-s js-menu-target" href="/new"
       aria-label="Create new…"
       data-ga-click="Header, create new, icon:add">
      <span class="octicon octicon-plus left"></span>
      <span class="dropdown-caret"></span>
    </a>

    <div class="dropdown-menu-content js-menu-content">
      <ul class="dropdown-menu dropdown-menu-sw">
        
<a class="dropdown-item" href="/new" data-ga-click="Header, create new repository">
  New repository
</a>


  <a class="dropdown-item" href="/organizations/new" data-ga-click="Header, create new organization">
    New organization
  </a>



  <div class="dropdown-divider"></div>
  <div class="dropdown-header">
    <span title="csc301-fall-2015/project-team9-L5101">This repository</span>
  </div>
    <a class="dropdown-item" href="/csc301-fall-2015/project-team9-L5101/issues/new" data-ga-click="Header, create new issue">
      New issue
    </a>

      </ul>
    </div>
  </li>

  <li class="header-nav-item dropdown js-menu-container">
    <a class="header-nav-link name tooltipped tooltipped-s js-menu-target" href="/xshirl1027"
       aria-label="View profile and more"
       data-ga-click="Header, show menu, icon:avatar">
      <img alt="@xshirl1027" class="avatar" height="20" src="https://avatars2.githubusercontent.com/u/12800360?v=3&amp;s=40" width="20" />
      <span class="dropdown-caret"></span>
    </a>

    <div class="dropdown-menu-content js-menu-content">
      <div class="dropdown-menu  dropdown-menu-sw">
        <div class=" dropdown-header header-nav-current-user css-truncate">
            Signed in as <strong class="css-truncate-target">xshirl1027</strong>

        </div>


        <div class="dropdown-divider"></div>

          <a class="dropdown-item" href="/xshirl1027" data-ga-click="Header, go to profile, text:your profile">
            Your profile
          </a>
        <a class="dropdown-item" href="/stars" data-ga-click="Header, go to starred repos, text:your stars">
          Your stars
        </a>
        <a class="dropdown-item" href="/explore" data-ga-click="Header, go to explore, text:explore">
          Explore
        </a>
          <a class="dropdown-item" href="/integrations" data-ga-click="Header, go to integrations, text:integrations">
            Integrations
          </a>
        <a class="dropdown-item" href="https://help.github.com" data-ga-click="Header, go to help, text:help">
          Help
        </a>

          <div class="dropdown-divider"></div>

          <a class="dropdown-item" href="/settings/profile" data-ga-click="Header, go to settings, icon:settings">
            Settings
          </a>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/logout" class="logout-form" data-form-nonce="36eed64f27793ac9a69b334de78c9666bd83dbfe" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="6CkYWRtiSNgop7qNzx0SNRpwoId4n5oHqNmRTA8zqYr45AzW4YZCUx6OerVQpBdlh33MnYqxROnBHXcjXPSLzA==" /></div>
            <button class="dropdown-item dropdown-signout" data-ga-click="Header, sign out, icon:logout">
              Sign out
            </button>
</form>
      </div>
    </div>
  </li>
</ul>


    
  </div>
</div>

      

      


    <div id="start-of-content" class="accessibility-aid"></div>

    <div id="js-flash-container">
</div>


    <div role="main" class="main-content">
        <div itemscope itemtype="http://schema.org/WebPage">
    <div id="js-repo-pjax-container" class="context-loader-container js-repo-nav-next" data-pjax-container>
      
<div class="pagehead repohead instapaper_ignore readability-menu experiment-repo-nav">
  <div class="container repohead-details-container">

    

<ul class="pagehead-actions">

  <li>
        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-form-nonce="36eed64f27793ac9a69b334de78c9666bd83dbfe" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="BBrevzkuD7EE5Ys81A/SbIcAlUqHoXvrglyrKGoS6N5mQWOYpGl5kxKO+MrIubhCtRi0Zf0ONjY5fKCX/R0D8w==" /></div>      <input id="repository_id" name="repository_id" type="hidden" value="43788620" />

        <div class="select-menu js-menu-container js-select-menu">
          <a href="/csc301-fall-2015/project-team9-L5101/subscription"
            class="btn btn-sm btn-with-count select-menu-button js-menu-target" role="button" tabindex="0" aria-haspopup="true"
            data-ga-click="Repository, click Watch settings, action:blob#show">
            <span class="js-select-button">
              <span class="octicon octicon-eye"></span>
              Unwatch
            </span>
          </a>
          <a class="social-count js-social-count" href="/csc301-fall-2015/project-team9-L5101/watchers">
            9
          </a>

        <div class="select-menu-modal-holder">
          <div class="select-menu-modal subscription-menu-modal js-menu-content" aria-hidden="true">
            <div class="select-menu-header">
              <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
              <span class="select-menu-title">Notifications</span>
            </div>

              <div class="select-menu-list js-navigation-container" role="menu">

                <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input id="do_included" name="do" type="radio" value="included" />
                    <span class="select-menu-item-heading">Not watching</span>
                    <span class="description">Be notified when participating or @mentioned.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-eye"></span>
                      Watch
                    </span>
                  </div>
                </div>

                <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input checked="checked" id="do_subscribed" name="do" type="radio" value="subscribed" />
                    <span class="select-menu-item-heading">Watching</span>
                    <span class="description">Be notified of all conversations.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-eye"></span>
                      Unwatch
                    </span>
                  </div>
                </div>

                <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input id="do_ignore" name="do" type="radio" value="ignore" />
                    <span class="select-menu-item-heading">Ignoring</span>
                    <span class="description">Never be notified.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-mute"></span>
                      Stop ignoring
                    </span>
                  </div>
                </div>

              </div>

            </div>
          </div>
        </div>
</form>
  </li>

  <li>
    
  <div class="js-toggler-container js-social-container starring-container ">

    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/csc301-fall-2015/project-team9-L5101/unstar" class="js-toggler-form starred js-unstar-button" data-form-nonce="36eed64f27793ac9a69b334de78c9666bd83dbfe" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="hxl7bFzddT1dkK4GIiWemkYUBQl1Zb85P3Kf7t0zP76OYSQe5ElWmbeVwINJ4H9vD8jVrydohRIOfcLmelY9hQ==" /></div>
      <button
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Unstar this repository" title="Unstar csc301-fall-2015/project-team9-L5101"
        data-ga-click="Repository, click unstar button, action:blob#show; text:Unstar">
        <span class="octicon octicon-star"></span>
        Unstar
      </button>
        <a class="social-count js-social-count" href="/csc301-fall-2015/project-team9-L5101/stargazers">
          1
        </a>
</form>
    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/csc301-fall-2015/project-team9-L5101/star" class="js-toggler-form unstarred js-star-button" data-form-nonce="36eed64f27793ac9a69b334de78c9666bd83dbfe" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="zoXfqpHIULUMhNmCDmG2PZNg+uHJJYUOOXC83LOnIt6UcQjge4Ay5rv1YIVI8BhDt9yorujPpTHF3nqCW+kUsw==" /></div>
      <button
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Star this repository" title="Star csc301-fall-2015/project-team9-L5101"
        data-ga-click="Repository, click star button, action:blob#show; text:Star">
        <span class="octicon octicon-star"></span>
        Star
      </button>
        <a class="social-count js-social-count" href="/csc301-fall-2015/project-team9-L5101/stargazers">
          1
        </a>
</form>  </div>

  </li>

  <li>
          <a href="#fork-destination-box" class="btn btn-sm btn-with-count"
              title="Fork your own copy of csc301-fall-2015/project-team9-L5101 to your account"
              aria-label="Fork your own copy of csc301-fall-2015/project-team9-L5101 to your account"
              rel="facebox"
              data-ga-click="Repository, show fork modal, action:blob#show; text:Fork">
            <span class="octicon octicon-repo-forked"></span>
            Fork
          </a>

          <div id="fork-destination-box" style="display: none;">
            <h2 class="facebox-header" data-facebox-id="facebox-header">Where should we fork this repository?</h2>
            <include-fragment src=""
                class="js-fork-select-fragment fork-select-fragment"
                data-url="/csc301-fall-2015/project-team9-L5101/fork?fragment=1">
              <img alt="Loading" height="64" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-128.gif" width="64" />
            </include-fragment>
          </div>

    <a href="/csc301-fall-2015/project-team9-L5101/network" class="social-count">
      5
    </a>
  </li>
</ul>

    <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title private ">
  <span class="octicon octicon-lock"></span>
  <span class="author"><a href="/csc301-fall-2015" class="url fn" itemprop="url" rel="author"><span itemprop="title">csc301-fall-2015</span></a></span><!--
--><span class="path-divider">/</span><!--
--><strong><a href="/csc301-fall-2015/project-team9-L5101" data-pjax="#js-repo-pjax-container">project-team9-L5101</a></strong>
    <span class="repo-private-label">private</span>

  <span class="page-context-loader">
    <img alt="" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
  </span>

</h1>

  </div>
  <div class="container">
    
<nav class="reponav js-repo-nav js-sidenav-container-pjax js-octicon-loaders"
     role="navigation"
     data-pjax="#js-repo-pjax-container"
     data-issue-count-url="/csc301-fall-2015/project-team9-L5101/issues/counts">

  <a href="/csc301-fall-2015/project-team9-L5101" aria-label="Code" aria-selected="true" class="js-selected-navigation-item selected reponav-item" data-hotkey="g c" data-selected-links="repo_source repo_downloads repo_commits repo_releases repo_tags repo_branches /csc301-fall-2015/project-team9-L5101">
    <span class="octicon octicon-code"></span>
    Code
</a>
    <a href="/csc301-fall-2015/project-team9-L5101/issues" class="js-selected-navigation-item reponav-item" data-hotkey="g i" data-selected-links="repo_issues repo_labels repo_milestones /csc301-fall-2015/project-team9-L5101/issues">
      <span class="octicon octicon-issue-opened"></span>
      Issues
      <span class="counter">28</span>

</a>
  <a href="/csc301-fall-2015/project-team9-L5101/pulls" class="js-selected-navigation-item reponav-item" data-hotkey="g p" data-selected-links="repo_pulls /csc301-fall-2015/project-team9-L5101/pulls">
    <span class="octicon octicon-git-pull-request"></span>
    Pull requests
    <span class="counter">1</span>

</a>
    <a href="/csc301-fall-2015/project-team9-L5101/wiki" class="js-selected-navigation-item reponav-item" data-hotkey="g w" data-selected-links="repo_wiki /csc301-fall-2015/project-team9-L5101/wiki">
      <span class="octicon octicon-book"></span>
      Wiki
</a>
  <a href="/csc301-fall-2015/project-team9-L5101/pulse" class="js-selected-navigation-item reponav-item" data-selected-links="pulse /csc301-fall-2015/project-team9-L5101/pulse">
    <span class="octicon octicon-pulse"></span>
    Pulse
</a>
  <a href="/csc301-fall-2015/project-team9-L5101/graphs" class="js-selected-navigation-item reponav-item" data-selected-links="repo_graphs repo_contributors /csc301-fall-2015/project-team9-L5101/graphs">
    <span class="octicon octicon-graph"></span>
    Graphs
</a>

</nav>

  </div>
</div>

<div class="container repo-container new-discussion-timeline experiment-repo-nav">
  <div class="repository-content">

    

<a href="/csc301-fall-2015/project-team9-L5101/blob/b826e4133c8b05d691fb01dec3c1bc79e4cc5526/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java" class="hidden js-permalink-shortcut" data-hotkey="y">Permalink</a>

<!-- blob contrib key: blob_contributors:v21:6c1bcbe33311de32ee50015f81302452 -->

  <div class="file-navigation js-zeroclipboard-container">
    
<div class="select-menu js-menu-container js-select-menu left">
  <button class="btn btn-sm select-menu-button js-menu-target css-truncate" data-hotkey="w"
    title="master"
    type="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <i>Branch:</i>
    <span class="js-select-button css-truncate-target">master</span>
  </button>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
        <span class="select-menu-title">Switch branches/tags</span>
      </div>

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Find or create a branch…" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Find or create a branch…">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" data-filter-placeholder="Find or create a branch…" class="js-select-menu-tab" role="tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" data-filter-placeholder="Find a tag…" class="js-select-menu-tab" role="tab">Tags</a>
            </li>
          </ul>
        </div>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches" role="menu">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/Justin-Branch/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="Justin-Branch"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="Justin-Branch">
                Justin-Branch
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/Shirl/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="Shirl"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="Shirl">
                Shirl
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/Tomek-Branch/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="Tomek-Branch"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="Tomek-Branch">
                Tomek-Branch
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/Ujash-Branch/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="Ujash-Branch"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="Ujash-Branch">
                Ujash-Branch
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open selected"
               href="/csc301-fall-2015/project-team9-L5101/blob/master/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="master"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="master">
                master
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/phase1-mark/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="phase1-mark"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="phase1-mark">
                phase1-mark
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/phase2-mark/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="phase2-mark"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="phase2-mark">
                phase2-mark
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/shirl/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="shirl"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="shirl">
                shirl
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/strategy-implementation/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="strategy-implementation"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="strategy-implementation">
                strategy-implementation
              </span>
            </a>
            <a class="select-menu-item js-navigation-item js-navigation-open "
               href="/csc301-fall-2015/project-team9-L5101/blob/ui-dev/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java"
               data-name="ui-dev"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="ui-dev">
                ui-dev
              </span>
            </a>
        </div>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/csc301-fall-2015/project-team9-L5101/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" data-form-nonce="36eed64f27793ac9a69b334de78c9666bd83dbfe" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="LlT30/MRNkHajipNBblv4vmK5EYkG+KBZKZor1O0rb2pI+VHihyMweO8maVG8r8QFok6D/QRHZfakuTMa51k7Q==" /></div>
            <span class="octicon octicon-git-branch select-menu-item-icon"></span>
            <div class="select-menu-item-text">
              <span class="select-menu-item-heading">Create branch: <span class="js-new-item-name"></span></span>
              <span class="description">from ‘master’</span>
            </div>
            <input type="hidden" name="name" id="name" class="js-new-item-value">
            <input type="hidden" name="branch" id="branch" value="master">
            <input type="hidden" name="path" id="path" value="automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java">
</form>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div>

    </div>
  </div>
</div>

    <div class="btn-group right">
      <a href="/csc301-fall-2015/project-team9-L5101/find/master"
            class="js-show-file-finder btn btn-sm"
            data-pjax
            data-hotkey="t">
        Find file
      </a>
      <button aria-label="Copy file path to clipboard" class="js-zeroclipboard btn btn-sm zeroclipboard-button tooltipped tooltipped-s" data-copied-hint="Copied!" type="button">Copy path</button>
    </div>
    <div class="breadcrumb js-zeroclipboard-target">
      <span class="repo-root js-repo-root"><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/csc301-fall-2015/project-team9-L5101" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">project-team9-L5101</span></a></span></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/csc301-fall-2015/project-team9-L5101/tree/master/automated-trading-simulator" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">automated-trading-simulator</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/csc301-fall-2015/project-team9-L5101/tree/master/automated-trading-simulator/src" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">src</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/csc301-fall-2015/project-team9-L5101/tree/master/automated-trading-simulator/src/test" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">test</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/csc301-fall-2015/project-team9-L5101/tree/master/automated-trading-simulator/src/test/java" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">java</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/csc301-fall-2015/project-team9-L5101/tree/master/automated-trading-simulator/src/test/java/autotradingsim" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">autotradingsim</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/csc301-fall-2015/project-team9-L5101/tree/master/automated-trading-simulator/src/test/java/autotradingsim/application" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">application</span></a></span><span class="separator">/</span><strong class="final-path">StrategyTest.java</strong>
    </div>
  </div>

<include-fragment class="commit-tease" src="/csc301-fall-2015/project-team9-L5101/contributors/master/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java">
  <div>
    Fetching contributors&hellip;
  </div>

  <div class="commit-tease-contributors">
    <img alt="" class="loader-loading left" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32-EAF2F5.gif" width="16" />
    <span class="loader-error">Cannot retrieve contributors at this time</span>
  </div>
</include-fragment>
<div class="file">
  <div class="file-header">
  <div class="file-actions">

    <div class="btn-group">
      <a href="/csc301-fall-2015/project-team9-L5101/raw/master/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java" class="btn btn-sm " id="raw-url">Raw</a>
        <a href="/csc301-fall-2015/project-team9-L5101/blame/master/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java" class="btn btn-sm js-update-url-with-hash">Blame</a>
      <a href="/csc301-fall-2015/project-team9-L5101/commits/master/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java" class="btn btn-sm " rel="nofollow">History</a>
    </div>

        <a class="octicon-btn tooltipped tooltipped-nw"
           href="https://windows.github.com"
           aria-label="Open this file in GitHub Desktop"
           data-ga-click="Repository, open with desktop, type:windows">
            <span class="octicon octicon-device-desktop"></span>
        </a>

        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/csc301-fall-2015/project-team9-L5101/edit/master/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java" class="inline-form js-update-url-with-hash" data-form-nonce="36eed64f27793ac9a69b334de78c9666bd83dbfe" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="hFp1/gvAc95qc1C74RwMblHSjyZ2OE8uq9TKZS8AaHundvetD4e+LYm1rVTtfeiEf/U3LL39GqT/s2QzwMHx1Q==" /></div>
          <button class="octicon-btn tooltipped tooltipped-nw" type="submit"
            aria-label="Edit this file" data-hotkey="e" data-disable-with>
            <span class="octicon octicon-pencil"></span>
          </button>
</form>        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/csc301-fall-2015/project-team9-L5101/delete/master/automated-trading-simulator/src/test/java/autotradingsim/application/StrategyTest.java" class="inline-form" data-form-nonce="36eed64f27793ac9a69b334de78c9666bd83dbfe" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="jSsDqD9NFYhMGQJ50pNU702eY7m5dVMoXU1KLT/iJAjP51LjWzhRquxlH3qG+Pr46Qt6/52rccODqIbg/oUakA==" /></div>
          <button class="octicon-btn octicon-btn-danger tooltipped tooltipped-nw" type="submit"
            aria-label="Delete this file" data-disable-with>
            <span class="octicon octicon-trashcan"></span>
          </button>
</form>  </div>

  <div class="file-info">
      217 lines (179 sloc)
      <span class="file-info-divider"></span>
    7.02 KB
  </div>
</div>

  

  <div class="blob-wrapper data type-java">
      <table class="highlight tab-size js-file-line-container" data-tab-size="8">
      <tr>
        <td id="L1" class="blob-num js-line-number" data-line-number="1"></td>
        <td id="LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-k">package</span> <span class="pl-smi">autotradingsim.application</span>;</td>
      </tr>
      <tr>
        <td id="L2" class="blob-num js-line-number" data-line-number="2"></td>
        <td id="LC2" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L3" class="blob-num js-line-number" data-line-number="3"></td>
        <td id="LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import static</span> <span class="pl-smi">org.junit.Assert.*</span>;</td>
      </tr>
      <tr>
        <td id="L4" class="blob-num js-line-number" data-line-number="4"></td>
        <td id="LC4" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L5" class="blob-num js-line-number" data-line-number="5"></td>
        <td id="LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">java.io.File</span>;</td>
      </tr>
      <tr>
        <td id="L6" class="blob-num js-line-number" data-line-number="6"></td>
        <td id="LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">java.math.BigDecimal</span>;</td>
      </tr>
      <tr>
        <td id="L7" class="blob-num js-line-number" data-line-number="7"></td>
        <td id="LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">java.util.HashSet</span>;</td>
      </tr>
      <tr>
        <td id="L8" class="blob-num js-line-number" data-line-number="8"></td>
        <td id="LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">java.util.Set</span>;</td>
      </tr>
      <tr>
        <td id="L9" class="blob-num js-line-number" data-line-number="9"></td>
        <td id="LC9" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L10" class="blob-num js-line-number" data-line-number="10"></td>
        <td id="LC10" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">org.junit.After</span>;</td>
      </tr>
      <tr>
        <td id="L11" class="blob-num js-line-number" data-line-number="11"></td>
        <td id="LC11" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">org.junit.AfterClass</span>;</td>
      </tr>
      <tr>
        <td id="L12" class="blob-num js-line-number" data-line-number="12"></td>
        <td id="LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">org.junit.Before</span>;</td>
      </tr>
      <tr>
        <td id="L13" class="blob-num js-line-number" data-line-number="13"></td>
        <td id="LC13" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">org.junit.Test</span>;</td>
      </tr>
      <tr>
        <td id="L14" class="blob-num js-line-number" data-line-number="14"></td>
        <td id="LC14" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L15" class="blob-num js-line-number" data-line-number="15"></td>
        <td id="LC15" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">autotradingsim.application.ITradingApplication</span>;</td>
      </tr>
      <tr>
        <td id="L16" class="blob-num js-line-number" data-line-number="16"></td>
        <td id="LC16" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">autotradingsim.application.TradingApplication</span>;</td>
      </tr>
      <tr>
        <td id="L17" class="blob-num js-line-number" data-line-number="17"></td>
        <td id="LC17" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L18" class="blob-num js-line-number" data-line-number="18"></td>
        <td id="LC18" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">autotradingsim.strategy.*</span>;</td>
      </tr>
      <tr>
        <td id="L19" class="blob-num js-line-number" data-line-number="19"></td>
        <td id="LC19" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">autotradingsim.strategy.simpleimpl.SimpleCondition</span>;</td>
      </tr>
      <tr>
        <td id="L20" class="blob-num js-line-number" data-line-number="20"></td>
        <td id="LC20" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-smi">autotradingsim.strategy.simpleimpl.SimpleStrategy</span>;</td>
      </tr>
      <tr>
        <td id="L21" class="blob-num js-line-number" data-line-number="21"></td>
        <td id="LC21" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L22" class="blob-num js-line-number" data-line-number="22"></td>
        <td id="LC22" class="blob-code blob-code-inner js-file-line"><span class="pl-k">public</span> <span class="pl-k">class</span> <span class="pl-en">StrategyTest</span> {</td>
      </tr>
      <tr>
        <td id="L23" class="blob-num js-line-number" data-line-number="23"></td>
        <td id="LC23" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L24" class="blob-num js-line-number" data-line-number="24"></td>
        <td id="LC24" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">private</span> <span class="pl-smi">String</span> PathToStrategies <span class="pl-k">=</span> <span class="pl-smi">System</span><span class="pl-k">.</span>getProperty(<span class="pl-s"><span class="pl-pds">&quot;</span>user.dir<span class="pl-pds">&quot;</span></span>) <span class="pl-k">+</span> <span class="pl-smi">File</span><span class="pl-k">.</span>separator <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>DATA<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> </td>
      </tr>
      <tr>
        <td id="L25" class="blob-num js-line-number" data-line-number="25"></td>
        <td id="LC25" class="blob-code blob-code-inner js-file-line">										<span class="pl-smi">File</span><span class="pl-k">.</span>separator <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>STRATEGIES<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> <span class="pl-smi">File</span><span class="pl-k">.</span>separator;</td>
      </tr>
      <tr>
        <td id="L26" class="blob-num js-line-number" data-line-number="26"></td>
        <td id="LC26" class="blob-code blob-code-inner js-file-line">	<span class="pl-smi">ITradingApplication</span> ApplicationUnderTest <span class="pl-k">=</span> <span class="pl-c1">null</span>;</td>
      </tr>
      <tr>
        <td id="L27" class="blob-num js-line-number" data-line-number="27"></td>
        <td id="LC27" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L28" class="blob-num js-line-number" data-line-number="28"></td>
        <td id="LC28" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@AfterClass</span></td>
      </tr>
      <tr>
        <td id="L29" class="blob-num js-line-number" data-line-number="29"></td>
        <td id="LC29" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">static</span> <span class="pl-k">void</span> <span class="pl-en">afterClass</span>() {</td>
      </tr>
      <tr>
        <td id="L30" class="blob-num js-line-number" data-line-number="30"></td>
        <td id="LC30" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">TradingApplication</span><span class="pl-k">.</span>destructObject();</td>
      </tr>
      <tr>
        <td id="L31" class="blob-num js-line-number" data-line-number="31"></td>
        <td id="LC31" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L32" class="blob-num js-line-number" data-line-number="32"></td>
        <td id="LC32" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L33" class="blob-num js-line-number" data-line-number="33"></td>
        <td id="LC33" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Before</span></td>
      </tr>
      <tr>
        <td id="L34" class="blob-num js-line-number" data-line-number="34"></td>
        <td id="LC34" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">setUp</span>() <span class="pl-k">throws</span> <span class="pl-smi">Exception</span> {</td>
      </tr>
      <tr>
        <td id="L35" class="blob-num js-line-number" data-line-number="35"></td>
        <td id="LC35" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">TradingApplication</span><span class="pl-k">.</span>clearFileSystem();</td>
      </tr>
      <tr>
        <td id="L36" class="blob-num js-line-number" data-line-number="36"></td>
        <td id="LC36" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span> <span class="pl-k">=</span> <span class="pl-smi">TradingApplication</span><span class="pl-k">.</span>getInstance();</td>
      </tr>
      <tr>
        <td id="L37" class="blob-num js-line-number" data-line-number="37"></td>
        <td id="LC37" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L38" class="blob-num js-line-number" data-line-number="38"></td>
        <td id="LC38" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L39" class="blob-num js-line-number" data-line-number="39"></td>
        <td id="LC39" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@After</span></td>
      </tr>
      <tr>
        <td id="L40" class="blob-num js-line-number" data-line-number="40"></td>
        <td id="LC40" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">tearDown</span>() <span class="pl-k">throws</span> <span class="pl-smi">Exception</span> {</td>
      </tr>
      <tr>
        <td id="L41" class="blob-num js-line-number" data-line-number="41"></td>
        <td id="LC41" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>clearMemory();</td>
      </tr>
      <tr>
        <td id="L42" class="blob-num js-line-number" data-line-number="42"></td>
        <td id="LC42" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L43" class="blob-num js-line-number" data-line-number="43"></td>
        <td id="LC43" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L44" class="blob-num js-line-number" data-line-number="44"></td>
        <td id="LC44" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L45" class="blob-num js-line-number" data-line-number="45"></td>
        <td id="LC45" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSetStrategyValid</span>(){</td>
      </tr>
      <tr>
        <td id="L46" class="blob-num js-line-number" data-line-number="46"></td>
        <td id="LC46" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> testStrat <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L47" class="blob-num js-line-number" data-line-number="47"></td>
        <td id="LC47" class="blob-code blob-code-inner js-file-line">		assertTrue(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>, testStrat));</td>
      </tr>
      <tr>
        <td id="L48" class="blob-num js-line-number" data-line-number="48"></td>
        <td id="LC48" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L49" class="blob-num js-line-number" data-line-number="49"></td>
        <td id="LC49" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L50" class="blob-num js-line-number" data-line-number="50"></td>
        <td id="LC50" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L51" class="blob-num js-line-number" data-line-number="51"></td>
        <td id="LC51" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSetStrategyInValid</span>(){</td>
      </tr>
      <tr>
        <td id="L52" class="blob-num js-line-number" data-line-number="52"></td>
        <td id="LC52" class="blob-code blob-code-inner js-file-line">		assertFalse(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">null</span>));</td>
      </tr>
      <tr>
        <td id="L53" class="blob-num js-line-number" data-line-number="53"></td>
        <td id="LC53" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L54" class="blob-num js-line-number" data-line-number="54"></td>
        <td id="LC54" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L55" class="blob-num js-line-number" data-line-number="55"></td>
        <td id="LC55" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L56" class="blob-num js-line-number" data-line-number="56"></td>
        <td id="LC56" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSetStrategyNameInValid</span>(){</td>
      </tr>
      <tr>
        <td id="L57" class="blob-num js-line-number" data-line-number="57"></td>
        <td id="LC57" class="blob-code blob-code-inner js-file-line">		assertFalse(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-c1">null</span>, <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>)));</td>
      </tr>
      <tr>
        <td id="L58" class="blob-num js-line-number" data-line-number="58"></td>
        <td id="LC58" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L59" class="blob-num js-line-number" data-line-number="59"></td>
        <td id="LC59" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L60" class="blob-num js-line-number" data-line-number="60"></td>
        <td id="LC60" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L61" class="blob-num js-line-number" data-line-number="61"></td>
        <td id="LC61" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSetStrategyTwice</span>(){</td>
      </tr>
      <tr>
        <td id="L62" class="blob-num js-line-number" data-line-number="62"></td>
        <td id="LC62" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> savingStrategy <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L63" class="blob-num js-line-number" data-line-number="63"></td>
        <td id="LC63" class="blob-code blob-code-inner js-file-line">		assertTrue(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>, savingStrategy));</td>
      </tr>
      <tr>
        <td id="L64" class="blob-num js-line-number" data-line-number="64"></td>
        <td id="LC64" class="blob-code blob-code-inner js-file-line">		assertFalse(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>, savingStrategy));</td>
      </tr>
      <tr>
        <td id="L65" class="blob-num js-line-number" data-line-number="65"></td>
        <td id="LC65" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L66" class="blob-num js-line-number" data-line-number="66"></td>
        <td id="LC66" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L67" class="blob-num js-line-number" data-line-number="67"></td>
        <td id="LC67" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L68" class="blob-num js-line-number" data-line-number="68"></td>
        <td id="LC68" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSetStrategyTwiceNullSecond</span>(){</td>
      </tr>
      <tr>
        <td id="L69" class="blob-num js-line-number" data-line-number="69"></td>
        <td id="LC69" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> savingStrategy <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L70" class="blob-num js-line-number" data-line-number="70"></td>
        <td id="LC70" class="blob-code blob-code-inner js-file-line">		assertTrue(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>, savingStrategy));</td>
      </tr>
      <tr>
        <td id="L71" class="blob-num js-line-number" data-line-number="71"></td>
        <td id="LC71" class="blob-code blob-code-inner js-file-line">		assertFalse(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">null</span>));</td>
      </tr>
      <tr>
        <td id="L72" class="blob-num js-line-number" data-line-number="72"></td>
        <td id="LC72" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L73" class="blob-num js-line-number" data-line-number="73"></td>
        <td id="LC73" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L74" class="blob-num js-line-number" data-line-number="74"></td>
        <td id="LC74" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L75" class="blob-num js-line-number" data-line-number="75"></td>
        <td id="LC75" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSetStrategyTwiceNullFirst</span>(){</td>
      </tr>
      <tr>
        <td id="L76" class="blob-num js-line-number" data-line-number="76"></td>
        <td id="LC76" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> savingStrategy <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L77" class="blob-num js-line-number" data-line-number="77"></td>
        <td id="LC77" class="blob-code blob-code-inner js-file-line">		assertFalse(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">null</span>));</td>
      </tr>
      <tr>
        <td id="L78" class="blob-num js-line-number" data-line-number="78"></td>
        <td id="LC78" class="blob-code blob-code-inner js-file-line">		assertTrue(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>Test<span class="pl-pds">&quot;</span></span>, savingStrategy));</td>
      </tr>
      <tr>
        <td id="L79" class="blob-num js-line-number" data-line-number="79"></td>
        <td id="LC79" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L80" class="blob-num js-line-number" data-line-number="80"></td>
        <td id="LC80" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L81" class="blob-num js-line-number" data-line-number="81"></td>
        <td id="LC81" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L82" class="blob-num js-line-number" data-line-number="82"></td>
        <td id="LC82" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testGetStrategyValidStrategy</span>(){</td>
      </tr>
      <tr>
        <td id="L83" class="blob-num js-line-number" data-line-number="83"></td>
        <td id="LC83" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> savingStrategy <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L84" class="blob-num js-line-number" data-line-number="84"></td>
        <td id="LC84" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>, savingStrategy);</td>
      </tr>
      <tr>
        <td id="L85" class="blob-num js-line-number" data-line-number="85"></td>
        <td id="LC85" class="blob-code blob-code-inner js-file-line">		assertEquals(savingStrategy, <span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>));</td>
      </tr>
      <tr>
        <td id="L86" class="blob-num js-line-number" data-line-number="86"></td>
        <td id="LC86" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L87" class="blob-num js-line-number" data-line-number="87"></td>
        <td id="LC87" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L88" class="blob-num js-line-number" data-line-number="88"></td>
        <td id="LC88" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L89" class="blob-num js-line-number" data-line-number="89"></td>
        <td id="LC89" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testGetStrategyInValidStrategy</span>(){</td>
      </tr>
      <tr>
        <td id="L90" class="blob-num js-line-number" data-line-number="90"></td>
        <td id="LC90" class="blob-code blob-code-inner js-file-line">		assertEquals(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>Invalid<span class="pl-pds">&quot;</span></span>), <span class="pl-c1">null</span>);</td>
      </tr>
      <tr>
        <td id="L91" class="blob-num js-line-number" data-line-number="91"></td>
        <td id="LC91" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L92" class="blob-num js-line-number" data-line-number="92"></td>
        <td id="LC92" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L93" class="blob-num js-line-number" data-line-number="93"></td>
        <td id="LC93" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L94" class="blob-num js-line-number" data-line-number="94"></td>
        <td id="LC94" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testGetStrategyNullStrategyName</span>(){</td>
      </tr>
      <tr>
        <td id="L95" class="blob-num js-line-number" data-line-number="95"></td>
        <td id="LC95" class="blob-code blob-code-inner js-file-line">		assertEquals(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-c1">null</span>), <span class="pl-c1">null</span>);</td>
      </tr>
      <tr>
        <td id="L96" class="blob-num js-line-number" data-line-number="96"></td>
        <td id="LC96" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L97" class="blob-num js-line-number" data-line-number="97"></td>
        <td id="LC97" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L98" class="blob-num js-line-number" data-line-number="98"></td>
        <td id="LC98" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L99" class="blob-num js-line-number" data-line-number="99"></td>
        <td id="LC99" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testGetStrategyMultipleStrategys</span>(){</td>
      </tr>
      <tr>
        <td id="L100" class="blob-num js-line-number" data-line-number="100"></td>
        <td id="LC100" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> savingStrategy1 <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving1<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L101" class="blob-num js-line-number" data-line-number="101"></td>
        <td id="LC101" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> savingStrategy2 <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving2<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L102" class="blob-num js-line-number" data-line-number="102"></td>
        <td id="LC102" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving1<span class="pl-pds">&quot;</span></span>, savingStrategy1);</td>
      </tr>
      <tr>
        <td id="L103" class="blob-num js-line-number" data-line-number="103"></td>
        <td id="LC103" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving2<span class="pl-pds">&quot;</span></span>, savingStrategy2);</td>
      </tr>
      <tr>
        <td id="L104" class="blob-num js-line-number" data-line-number="104"></td>
        <td id="LC104" class="blob-code blob-code-inner js-file-line">		assertEquals(savingStrategy1, <span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving1<span class="pl-pds">&quot;</span></span>));</td>
      </tr>
      <tr>
        <td id="L105" class="blob-num js-line-number" data-line-number="105"></td>
        <td id="LC105" class="blob-code blob-code-inner js-file-line">		assertEquals(savingStrategy2, <span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving2<span class="pl-pds">&quot;</span></span>));</td>
      </tr>
      <tr>
        <td id="L106" class="blob-num js-line-number" data-line-number="106"></td>
        <td id="LC106" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L107" class="blob-num js-line-number" data-line-number="107"></td>
        <td id="LC107" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L108" class="blob-num js-line-number" data-line-number="108"></td>
        <td id="LC108" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L109" class="blob-num js-line-number" data-line-number="109"></td>
        <td id="LC109" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testGetStrategyMultipleGetStrategy</span>(){</td>
      </tr>
      <tr>
        <td id="L110" class="blob-num js-line-number" data-line-number="110"></td>
        <td id="LC110" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> savingStrategy1 <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving1<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L111" class="blob-num js-line-number" data-line-number="111"></td>
        <td id="LC111" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> savingStrategy2 <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving2<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L112" class="blob-num js-line-number" data-line-number="112"></td>
        <td id="LC112" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving1<span class="pl-pds">&quot;</span></span>, savingStrategy1);</td>
      </tr>
      <tr>
        <td id="L113" class="blob-num js-line-number" data-line-number="113"></td>
        <td id="LC113" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving2<span class="pl-pds">&quot;</span></span>, savingStrategy2);</td>
      </tr>
      <tr>
        <td id="L114" class="blob-num js-line-number" data-line-number="114"></td>
        <td id="LC114" class="blob-code blob-code-inner js-file-line">		assertEquals(savingStrategy1, <span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving1<span class="pl-pds">&quot;</span></span>));</td>
      </tr>
      <tr>
        <td id="L115" class="blob-num js-line-number" data-line-number="115"></td>
        <td id="LC115" class="blob-code blob-code-inner js-file-line">		assertEquals(savingStrategy1, <span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving1<span class="pl-pds">&quot;</span></span>));</td>
      </tr>
      <tr>
        <td id="L116" class="blob-num js-line-number" data-line-number="116"></td>
        <td id="LC116" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L117" class="blob-num js-line-number" data-line-number="117"></td>
        <td id="LC117" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L118" class="blob-num js-line-number" data-line-number="118"></td>
        <td id="LC118" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L119" class="blob-num js-line-number" data-line-number="119"></td>
        <td id="LC119" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSavingEmptyStrategy</span>(){</td>
      </tr>
      <tr>
        <td id="L120" class="blob-num js-line-number" data-line-number="120"></td>
        <td id="LC120" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">String</span> <span class="pl-smi">ExpectedFileExists</span> <span class="pl-k">=</span> <span class="pl-smi">PathToStrategies</span> <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>;</td>
      </tr>
      <tr>
        <td id="L121" class="blob-num js-line-number" data-line-number="121"></td>
        <td id="LC121" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>, <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>));</td>
      </tr>
      <tr>
        <td id="L122" class="blob-num js-line-number" data-line-number="122"></td>
        <td id="LC122" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">File</span> testingFile <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">File</span>(<span class="pl-smi">ExpectedFileExists</span>);</td>
      </tr>
      <tr>
        <td id="L123" class="blob-num js-line-number" data-line-number="123"></td>
        <td id="LC123" class="blob-code blob-code-inner js-file-line">		assertTrue(testingFile<span class="pl-k">.</span>exists());</td>
      </tr>
      <tr>
        <td id="L124" class="blob-num js-line-number" data-line-number="124"></td>
        <td id="LC124" class="blob-code blob-code-inner js-file-line">		testingFile<span class="pl-k">.</span>delete();</td>
      </tr>
      <tr>
        <td id="L125" class="blob-num js-line-number" data-line-number="125"></td>
        <td id="LC125" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L126" class="blob-num js-line-number" data-line-number="126"></td>
        <td id="LC126" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L127" class="blob-num js-line-number" data-line-number="127"></td>
        <td id="LC127" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L128" class="blob-num js-line-number" data-line-number="128"></td>
        <td id="LC128" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSavingStrategyOneEmptyRule</span>(){</td>
      </tr>
      <tr>
        <td id="L129" class="blob-num js-line-number" data-line-number="129"></td>
        <td id="LC129" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">String</span> <span class="pl-smi">ExpectedFileExists</span> <span class="pl-k">=</span> <span class="pl-smi">PathToStrategies</span> <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>;</td>
      </tr>
      <tr>
        <td id="L130" class="blob-num js-line-number" data-line-number="130"></td>
        <td id="LC130" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> mySimpleStrat <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L131" class="blob-num js-line-number" data-line-number="131"></td>
        <td id="LC131" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IRule</span> myRule <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Rule</span>();</td>
      </tr>
      <tr>
        <td id="L132" class="blob-num js-line-number" data-line-number="132"></td>
        <td id="LC132" class="blob-code blob-code-inner js-file-line">		mySimpleStrat<span class="pl-k">.</span>addRule(myRule);</td>
      </tr>
      <tr>
        <td id="L133" class="blob-num js-line-number" data-line-number="133"></td>
        <td id="LC133" class="blob-code blob-code-inner js-file-line">		</td>
      </tr>
      <tr>
        <td id="L134" class="blob-num js-line-number" data-line-number="134"></td>
        <td id="LC134" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>, mySimpleStrat);</td>
      </tr>
      <tr>
        <td id="L135" class="blob-num js-line-number" data-line-number="135"></td>
        <td id="LC135" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">File</span> testingFile <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">File</span>(<span class="pl-smi">ExpectedFileExists</span>);</td>
      </tr>
      <tr>
        <td id="L136" class="blob-num js-line-number" data-line-number="136"></td>
        <td id="LC136" class="blob-code blob-code-inner js-file-line">		assertTrue(testingFile<span class="pl-k">.</span>exists());</td>
      </tr>
      <tr>
        <td id="L137" class="blob-num js-line-number" data-line-number="137"></td>
        <td id="LC137" class="blob-code blob-code-inner js-file-line">		testingFile<span class="pl-k">.</span>delete();</td>
      </tr>
      <tr>
        <td id="L138" class="blob-num js-line-number" data-line-number="138"></td>
        <td id="LC138" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L139" class="blob-num js-line-number" data-line-number="139"></td>
        <td id="LC139" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L140" class="blob-num js-line-number" data-line-number="140"></td>
        <td id="LC140" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L141" class="blob-num js-line-number" data-line-number="141"></td>
        <td id="LC141" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSavingStrategyMultipleEmptyRules</span>(){</td>
      </tr>
      <tr>
        <td id="L142" class="blob-num js-line-number" data-line-number="142"></td>
        <td id="LC142" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">String</span> <span class="pl-smi">ExpectedFileExists</span> <span class="pl-k">=</span> <span class="pl-smi">PathToStrategies</span> <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>;</td>
      </tr>
      <tr>
        <td id="L143" class="blob-num js-line-number" data-line-number="143"></td>
        <td id="LC143" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> mySimpleStrat <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L144" class="blob-num js-line-number" data-line-number="144"></td>
        <td id="LC144" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IRule</span> myRule1 <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Rule</span>();</td>
      </tr>
      <tr>
        <td id="L145" class="blob-num js-line-number" data-line-number="145"></td>
        <td id="LC145" class="blob-code blob-code-inner js-file-line">		mySimpleStrat<span class="pl-k">.</span>addRule(myRule1);</td>
      </tr>
      <tr>
        <td id="L146" class="blob-num js-line-number" data-line-number="146"></td>
        <td id="LC146" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IRule</span> myRule2 <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Rule</span>();</td>
      </tr>
      <tr>
        <td id="L147" class="blob-num js-line-number" data-line-number="147"></td>
        <td id="LC147" class="blob-code blob-code-inner js-file-line">		mySimpleStrat<span class="pl-k">.</span>addRule(myRule2);</td>
      </tr>
      <tr>
        <td id="L148" class="blob-num js-line-number" data-line-number="148"></td>
        <td id="LC148" class="blob-code blob-code-inner js-file-line">		</td>
      </tr>
      <tr>
        <td id="L149" class="blob-num js-line-number" data-line-number="149"></td>
        <td id="LC149" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>, mySimpleStrat);</td>
      </tr>
      <tr>
        <td id="L150" class="blob-num js-line-number" data-line-number="150"></td>
        <td id="LC150" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">File</span> testingFile <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">File</span>(<span class="pl-smi">ExpectedFileExists</span>);</td>
      </tr>
      <tr>
        <td id="L151" class="blob-num js-line-number" data-line-number="151"></td>
        <td id="LC151" class="blob-code blob-code-inner js-file-line">		assertTrue(testingFile<span class="pl-k">.</span>exists());</td>
      </tr>
      <tr>
        <td id="L152" class="blob-num js-line-number" data-line-number="152"></td>
        <td id="LC152" class="blob-code blob-code-inner js-file-line">		testingFile<span class="pl-k">.</span>delete();</td>
      </tr>
      <tr>
        <td id="L153" class="blob-num js-line-number" data-line-number="153"></td>
        <td id="LC153" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L154" class="blob-num js-line-number" data-line-number="154"></td>
        <td id="LC154" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L155" class="blob-num js-line-number" data-line-number="155"></td>
        <td id="LC155" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L156" class="blob-num js-line-number" data-line-number="156"></td>
        <td id="LC156" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSavingStrategyOneRuleOneCondition</span>(){</td>
      </tr>
      <tr>
        <td id="L157" class="blob-num js-line-number" data-line-number="157"></td>
        <td id="LC157" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">String</span> <span class="pl-smi">ExpectedFileExists</span> <span class="pl-k">=</span> <span class="pl-smi">PathToStrategies</span> <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>;</td>
      </tr>
      <tr>
        <td id="L158" class="blob-num js-line-number" data-line-number="158"></td>
        <td id="LC158" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> mySimpleStrat <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L159" class="blob-num js-line-number" data-line-number="159"></td>
        <td id="LC159" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IRule</span> myRule <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Rule</span>();</td>
      </tr>
      <tr>
        <td id="L160" class="blob-num js-line-number" data-line-number="160"></td>
        <td id="LC160" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IAction</span> action <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Action</span>();</td>
      </tr>
      <tr>
        <td id="L161" class="blob-num js-line-number" data-line-number="161"></td>
        <td id="LC161" class="blob-code blob-code-inner js-file-line">		myRule<span class="pl-k">.</span>addAction(action );</td>
      </tr>
      <tr>
        <td id="L162" class="blob-num js-line-number" data-line-number="162"></td>
        <td id="LC162" class="blob-code blob-code-inner js-file-line">		<span class="pl-c">//ICondition myCondition = new SimpleCondition(ICondition.Comparator.EQ, new BigDecimal(10));</span></td>
      </tr>
      <tr>
        <td id="L163" class="blob-num js-line-number" data-line-number="163"></td>
        <td id="LC163" class="blob-code blob-code-inner js-file-line">		<span class="pl-c">//myRule.addCondition(myCondition);</span></td>
      </tr>
      <tr>
        <td id="L164" class="blob-num js-line-number" data-line-number="164"></td>
        <td id="LC164" class="blob-code blob-code-inner js-file-line">		<span class="pl-c">//mySimpleStrat.addRule(myRule);</span></td>
      </tr>
      <tr>
        <td id="L165" class="blob-num js-line-number" data-line-number="165"></td>
        <td id="LC165" class="blob-code blob-code-inner js-file-line">		<span class="pl-c">// TODO Solidify the serialization of conditions</span></td>
      </tr>
      <tr>
        <td id="L166" class="blob-num js-line-number" data-line-number="166"></td>
        <td id="LC166" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSingleRule<span class="pl-pds">&quot;</span></span>, mySimpleStrat);</td>
      </tr>
      <tr>
        <td id="L167" class="blob-num js-line-number" data-line-number="167"></td>
        <td id="LC167" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">File</span> testingFile <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">File</span>(<span class="pl-smi">ExpectedFileExists</span>);</td>
      </tr>
      <tr>
        <td id="L168" class="blob-num js-line-number" data-line-number="168"></td>
        <td id="LC168" class="blob-code blob-code-inner js-file-line">		assertTrue(testingFile<span class="pl-k">.</span>exists());</td>
      </tr>
      <tr>
        <td id="L169" class="blob-num js-line-number" data-line-number="169"></td>
        <td id="LC169" class="blob-code blob-code-inner js-file-line">		testingFile<span class="pl-k">.</span>delete();</td>
      </tr>
      <tr>
        <td id="L170" class="blob-num js-line-number" data-line-number="170"></td>
        <td id="LC170" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L171" class="blob-num js-line-number" data-line-number="171"></td>
        <td id="LC171" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L172" class="blob-num js-line-number" data-line-number="172"></td>
        <td id="LC172" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L173" class="blob-num js-line-number" data-line-number="173"></td>
        <td id="LC173" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testSavingLoadingStrategy</span>(){</td>
      </tr>
      <tr>
        <td id="L174" class="blob-num js-line-number" data-line-number="174"></td>
        <td id="LC174" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">String</span> <span class="pl-smi">ExpectedFileExists</span> <span class="pl-k">=</span> <span class="pl-smi">PathToStrategies</span> <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>;</td>
      </tr>
      <tr>
        <td id="L175" class="blob-num js-line-number" data-line-number="175"></td>
        <td id="LC175" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> myStrategy <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L176" class="blob-num js-line-number" data-line-number="176"></td>
        <td id="LC176" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>, myStrategy);</td>
      </tr>
      <tr>
        <td id="L177" class="blob-num js-line-number" data-line-number="177"></td>
        <td id="LC177" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">File</span> testingFile <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">File</span>(<span class="pl-smi">ExpectedFileExists</span>);</td>
      </tr>
      <tr>
        <td id="L178" class="blob-num js-line-number" data-line-number="178"></td>
        <td id="LC178" class="blob-code blob-code-inner js-file-line">		assertTrue(testingFile<span class="pl-k">.</span>exists());</td>
      </tr>
      <tr>
        <td id="L179" class="blob-num js-line-number" data-line-number="179"></td>
        <td id="LC179" class="blob-code blob-code-inner js-file-line">		</td>
      </tr>
      <tr>
        <td id="L180" class="blob-num js-line-number" data-line-number="180"></td>
        <td id="LC180" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> expectedMyStrategy <span class="pl-k">=</span> <span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L181" class="blob-num js-line-number" data-line-number="181"></td>
        <td id="LC181" class="blob-code blob-code-inner js-file-line">		assertEquals(myStrategy, expectedMyStrategy);</td>
      </tr>
      <tr>
        <td id="L182" class="blob-num js-line-number" data-line-number="182"></td>
        <td id="LC182" class="blob-code blob-code-inner js-file-line">		</td>
      </tr>
      <tr>
        <td id="L183" class="blob-num js-line-number" data-line-number="183"></td>
        <td id="LC183" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>clearMemory();</td>
      </tr>
      <tr>
        <td id="L184" class="blob-num js-line-number" data-line-number="184"></td>
        <td id="LC184" class="blob-code blob-code-inner js-file-line">		</td>
      </tr>
      <tr>
        <td id="L185" class="blob-num js-line-number" data-line-number="185"></td>
        <td id="LC185" class="blob-code blob-code-inner js-file-line">		expectedMyStrategy <span class="pl-k">=</span> <span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>TestSaving<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L186" class="blob-num js-line-number" data-line-number="186"></td>
        <td id="LC186" class="blob-code blob-code-inner js-file-line">		assertEquals(myStrategy<span class="pl-k">.</span>getName(), expectedMyStrategy<span class="pl-k">.</span>getName());</td>
      </tr>
      <tr>
        <td id="L187" class="blob-num js-line-number" data-line-number="187"></td>
        <td id="LC187" class="blob-code blob-code-inner js-file-line">		</td>
      </tr>
      <tr>
        <td id="L188" class="blob-num js-line-number" data-line-number="188"></td>
        <td id="LC188" class="blob-code blob-code-inner js-file-line">		testingFile<span class="pl-k">.</span>delete();</td>
      </tr>
      <tr>
        <td id="L189" class="blob-num js-line-number" data-line-number="189"></td>
        <td id="LC189" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L190" class="blob-num js-line-number" data-line-number="190"></td>
        <td id="LC190" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L191" class="blob-num js-line-number" data-line-number="191"></td>
        <td id="LC191" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L192" class="blob-num js-line-number" data-line-number="192"></td>
        <td id="LC192" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testAvailableStrategiesEmpty</span>(){</td>
      </tr>
      <tr>
        <td id="L193" class="blob-num js-line-number" data-line-number="193"></td>
        <td id="LC193" class="blob-code blob-code-inner js-file-line">		assertTrue(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getAvailableStrategies()<span class="pl-k">.</span>isEmpty());</td>
      </tr>
      <tr>
        <td id="L194" class="blob-num js-line-number" data-line-number="194"></td>
        <td id="LC194" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L195" class="blob-num js-line-number" data-line-number="195"></td>
        <td id="LC195" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L196" class="blob-num js-line-number" data-line-number="196"></td>
        <td id="LC196" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L197" class="blob-num js-line-number" data-line-number="197"></td>
        <td id="LC197" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testAvailableStrategiesSingleStrategy</span>(){</td>
      </tr>
      <tr>
        <td id="L198" class="blob-num js-line-number" data-line-number="198"></td>
        <td id="LC198" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> testStrategy <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>newStrategy<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L199" class="blob-num js-line-number" data-line-number="199"></td>
        <td id="LC199" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>newStrategy<span class="pl-pds">&quot;</span></span>, testStrategy);</td>
      </tr>
      <tr>
        <td id="L200" class="blob-num js-line-number" data-line-number="200"></td>
        <td id="LC200" class="blob-code blob-code-inner js-file-line">		<span class="pl-k">Set&lt;<span class="pl-smi">String</span>&gt;</span> expectedSet <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-k">HashSet&lt;<span class="pl-smi">String</span>&gt;</span>();</td>
      </tr>
      <tr>
        <td id="L201" class="blob-num js-line-number" data-line-number="201"></td>
        <td id="LC201" class="blob-code blob-code-inner js-file-line">		expectedSet<span class="pl-k">.</span>add(<span class="pl-s"><span class="pl-pds">&quot;</span>newStrategy<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L202" class="blob-num js-line-number" data-line-number="202"></td>
        <td id="LC202" class="blob-code blob-code-inner js-file-line">		assertEquals(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getAvailableStrategies(), expectedSet);</td>
      </tr>
      <tr>
        <td id="L203" class="blob-num js-line-number" data-line-number="203"></td>
        <td id="LC203" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L204" class="blob-num js-line-number" data-line-number="204"></td>
        <td id="LC204" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L205" class="blob-num js-line-number" data-line-number="205"></td>
        <td id="LC205" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">@Test</span></td>
      </tr>
      <tr>
        <td id="L206" class="blob-num js-line-number" data-line-number="206"></td>
        <td id="LC206" class="blob-code blob-code-inner js-file-line">	<span class="pl-k">public</span> <span class="pl-k">void</span> <span class="pl-en">testAvailableStrategiesSingleClearStrategy</span>(){</td>
      </tr>
      <tr>
        <td id="L207" class="blob-num js-line-number" data-line-number="207"></td>
        <td id="LC207" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">IStrategy</span> testStrategy <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">Strategy</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>newStrategy<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L208" class="blob-num js-line-number" data-line-number="208"></td>
        <td id="LC208" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>setStrategy(<span class="pl-s"><span class="pl-pds">&quot;</span>newStrategy<span class="pl-pds">&quot;</span></span>, testStrategy);</td>
      </tr>
      <tr>
        <td id="L209" class="blob-num js-line-number" data-line-number="209"></td>
        <td id="LC209" class="blob-code blob-code-inner js-file-line">		<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>clearMemory();</td>
      </tr>
      <tr>
        <td id="L210" class="blob-num js-line-number" data-line-number="210"></td>
        <td id="LC210" class="blob-code blob-code-inner js-file-line">		<span class="pl-k">Set&lt;<span class="pl-smi">String</span>&gt;</span> expectedSet <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-k">HashSet&lt;<span class="pl-smi">String</span>&gt;</span>();</td>
      </tr>
      <tr>
        <td id="L211" class="blob-num js-line-number" data-line-number="211"></td>
        <td id="LC211" class="blob-code blob-code-inner js-file-line">		expectedSet<span class="pl-k">.</span>add(<span class="pl-s"><span class="pl-pds">&quot;</span>newStrategy<span class="pl-pds">&quot;</span></span>);</td>
      </tr>
      <tr>
        <td id="L212" class="blob-num js-line-number" data-line-number="212"></td>
        <td id="LC212" class="blob-code blob-code-inner js-file-line">		assertEquals(<span class="pl-smi">ApplicationUnderTest</span><span class="pl-k">.</span>getAvailableStrategies(), expectedSet);</td>
      </tr>
      <tr>
        <td id="L213" class="blob-num js-line-number" data-line-number="213"></td>
        <td id="LC213" class="blob-code blob-code-inner js-file-line">	}</td>
      </tr>
      <tr>
        <td id="L214" class="blob-num js-line-number" data-line-number="214"></td>
        <td id="LC214" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L215" class="blob-num js-line-number" data-line-number="215"></td>
        <td id="LC215" class="blob-code blob-code-inner js-file-line">	</td>
      </tr>
      <tr>
        <td id="L216" class="blob-num js-line-number" data-line-number="216"></td>
        <td id="LC216" class="blob-code blob-code-inner js-file-line">}</td>
      </tr>
</table>

  </div>

</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="" class="js-jump-to-line-form" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" aria-label="Jump to line" autofocus>
    <button type="submit" class="btn">Go</button>
</form></div>

  </div>
  <div class="modal-backdrop"></div>
</div>

    </div>
  </div>

    </div>

      <div class="container">
  <div class="site-footer" role="contentinfo">
    <ul class="site-footer-links right">
        <li><a href="https://status.github.com/" data-ga-click="Footer, go to status, text:status">Status</a></li>
      <li><a href="https://developer.github.com" data-ga-click="Footer, go to api, text:api">API</a></li>
      <li><a href="https://training.github.com" data-ga-click="Footer, go to training, text:training">Training</a></li>
      <li><a href="https://shop.github.com" data-ga-click="Footer, go to shop, text:shop">Shop</a></li>
        <li><a href="https://github.com/blog" data-ga-click="Footer, go to blog, text:blog">Blog</a></li>
        <li><a href="https://github.com/about" data-ga-click="Footer, go to about, text:about">About</a></li>
        <li><a href="https://github.com/pricing" data-ga-click="Footer, go to pricing, text:pricing">Pricing</a></li>

    </ul>

    <a href="https://github.com" aria-label="Homepage">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
</a>
    <ul class="site-footer-links">
      <li>&copy; 2015 <span title="0.09077s from github-fe134-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="https://github.com/site/terms" data-ga-click="Footer, go to terms, text:terms">Terms</a></li>
        <li><a href="https://github.com/site/privacy" data-ga-click="Footer, go to privacy, text:privacy">Privacy</a></li>
        <li><a href="https://github.com/security" data-ga-click="Footer, go to security, text:security">Security</a></li>
        <li><a href="https://github.com/contact" data-ga-click="Footer, go to contact, text:contact">Contact</a></li>
        <li><a href="https://help.github.com" data-ga-click="Footer, go to help, text:help">Help</a></li>
    </ul>
  </div>
</div>



    
    
    

    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <button type="button" class="flash-close js-flash-close js-ajax-error-dismiss" aria-label="Dismiss error">
        <span class="octicon octicon-x"></span>
      </button>
      Something went wrong with that request. Please try again.
    </div>


      <script crossorigin="anonymous" src="https://assets-cdn.github.com/assets/frameworks-7d180c2bb5779ecb7ab5d04ce8af999e73836dcf0df1a8c44b69c62a1de0732f.js"></script>
      <script async="async" crossorigin="anonymous" src="https://assets-cdn.github.com/assets/github-1d8d50cda3479974ffdf8694515810878d7cc6c245c1ced4920566ffcd2eb27a.js"></script>
      
      
    <div class="js-stale-session-flash stale-session-flash flash flash-warn flash-banner hidden">
      <span class="octicon octicon-alert"></span>
      <span class="signed-in-tab-flash">You signed in with another tab or window. <a href="">Reload</a> to refresh your session.</span>
      <span class="signed-out-tab-flash">You signed out in another tab or window. <a href="">Reload</a> to refresh your session.</span>
    </div>
  </body>
</html>

