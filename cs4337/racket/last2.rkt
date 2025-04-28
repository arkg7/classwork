#lang racket

(define (last2 a) (
                 cond
                  [(null? a) '()]
                  [(null? (cdr a)) a]
                  [(list-tail a (- (length a) 2))]
                 )
  )

(last2 '(a b (c d) e))