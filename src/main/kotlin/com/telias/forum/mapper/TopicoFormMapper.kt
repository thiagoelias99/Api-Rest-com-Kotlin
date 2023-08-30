package com.telias.forum.mapper

import com.telias.forum.dto.NotoTopicoForm
import com.telias.forum.models.Topico
import com.telias.forum.services.CursoService
import com.telias.forum.services.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
): Mapper<NotoTopicoForm, Topico> {
    override fun map(t: NotoTopicoForm): Topico {
        return             Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor),
        )
    }

}
