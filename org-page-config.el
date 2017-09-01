(require 'org-page)
(setq op/repository-directory "/home/alvaro/github/alvarogonzalezsotillo.github.io")
(setq op/repository-org-branch "source")
(setq op/repository-html-branch "gh-pages")
(setq op/site-domain "https://alvarogonzalezsotillo.github.io/")
;;; for commenting, you can choose either disqus, duoshuo or hashover
(setq op/personal-disqus-shortname "your_disqus_shortname")
(setq op/hashover-comments t)

(setq op/personal-github-link "https://github.com/alvarogonzalezsotillo")



(setq op/personal-avatar "/media/img/octaedron.png" )
(setq op/theme-root-directory "/home/alvaro/github/alvarogonzalezsotillo.github.io/themes/")
(setq op/theme 'alvaro)

;;; the configuration below are optional
;(setq op/personal-google-analytics-id "your_google_analytics_id")

(op/do-publication-and-preview-site op/site-preview-directory)
