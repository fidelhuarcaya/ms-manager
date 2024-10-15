package org.copper.manager.service.craft;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.CraftRequest;
import org.copper.manager.dto.response.CraftResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.CraftMapper;
import org.copper.manager.repository.CraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CraftServiceImpl implements CraftService{
    private final CraftRepository craftRepository;
    private final CraftMapper craftMapper;

    @Override
    public List<CraftResponse> getAll() {
        return craftRepository.findAll().stream().map(craftMapper::toResponse).toList();
    }

    @Override
    public CraftResponse create(CraftRequest request) {
        return craftMapper.toResponse(
                craftRepository.save(craftMapper.toEntity(request)));
    }

    @Override
    public CraftResponse update(Long id, CraftRequest request) {
        if (!craftRepository.existsById(id)){
            throw new RequestException("No existe Manual con id: "+id);
        }
        request.setId(id);
        return craftMapper.toResponse(
                craftRepository.save(craftMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        craftRepository.deleteById(id);
    }
}
