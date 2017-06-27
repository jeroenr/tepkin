package com.github.jeroenr.tepkin.protocol.command

import com.github.jeroenr.bson.BsonDocument
import com.github.jeroenr.bson.BsonDsl._
import com.github.jeroenr.bson.util.Converters.md5Hex

case class Authenticate(databaseName: String,
                        username: String,
                        password: String,
                        nonce: String) extends Command {
  override val command: BsonDocument = {
    ("authenticate" := 1) ~
      ("user" := username) ~
      ("nonce" := nonce) ~
      ("key" := md5Hex(nonce + username + md5Hex(s"$username:mongo:$password")))
  }
}
