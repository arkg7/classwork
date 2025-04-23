#lang racket

(define (gen-list a b) (
                        if (<= a b) (cons a (gen-list (+ a 1) b)) '()
                        )
  )

(gen-list 1 5)
