

;;; Code:

(require 'org-page)
(defvar raiz-de-blog "/home/alvaro/github/alvarogonzalezsotillo.github.io")

(defun configurar-blog()
  (interactive)

  (require 'org-page)

  (setq op/repository-directory raiz-de-blog)
  (setq op/repository-org-branch "source")
  (setq op/repository-html-branch "master")
  (setq op/site-domain "https://alvarogonzalezsotillo.github.io/")

  ;;; for commenting, you can choose either disqus, duoshuo or hashover
  ;;; (setq op/personal-disqus-shortname "alvarogonzalezsotillo")
  ;;; (setq op/hashover-comments nil)

  (setq op/personal-github-link "https://github.com/alvarogonzalezsotillo")

  (setq op/personal-avatar "/media/img/octaedron.png" )
  (setq op/theme-root-directory (concat raiz-de-blog "/themes/") )
  (setq op/theme 'alvaro)

  (setq op/site-main-title "Álvaro González Sotillo")
  (setq op/site-sub-title ""))


(defun generar-blog-rapido ()
  (interactive)
  (configurar-blog)
  (op/do-publication nil nil op/site-preview-directory)
  (httpd-stop)
  (httpd-serve-directory op/site-preview-directory)
  (browse-url (format "http://%s:%d" system-name httpd-port)))



(defun generar-blog()
  (interactive)

  (configurar-blog)
  ;; TRAS LA CONFIGURACIÓN, GENERO EL SITIO DE PRUEBA
  (setq httpd-host "0.0.0.0")
  (setq httpd-port 8081)
  (op/do-publication-and-preview-site op/site-preview-directory))

(defun publicar-blog()
  (interactive)
  (configurar-blog)
  (op/do-publication t nil nil t nil))

;;; org-page-config.el ends here


