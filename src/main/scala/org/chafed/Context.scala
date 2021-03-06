package org.chafed

import scala.util.Random

/**
 * The context by which a response was achieved. This is useful to know which
 * what the last page was when following relative paths, the cookie jar etc.
 */
case class Context(
  val request: Request = Request.Nil,
  val cookies: List[Cookie] = Nil,
  maxDepth: Int = 10) {
  
  private lazy val id = new Random().nextInt
  
  override def toString = "#%8x".format(id)
}

object Context {
  /**
   * Create a fresh context with a user agent identity.
   */
  private[chafed] def newWithIdentity(identity: String): Context = {
    val headers = header.UserAgent(identity) ::
      header.Accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") :: Nil
    Context(request = Request.Nil.copy(headers = headers))
  }
}